/* mapstruct-spi-protobuf-immutables
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.accessors;

import org.mapstruct.ap.internal.util.ImmutablesConstants;
import org.mapstruct.ap.internal.util.Nouns;
import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;
import org.mapstruct.ap.spi.MapStructProcessingEnvironment;
import org.mapstruct.ap.spi.util.IntrospectorUtils;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import java.util.*;

/**
 * Accessor naming strategy that is aware of the special naming conventions used in protobuf-generated classes.
 * <p>
 * Optionally supports Immutables as counterpart, much like
 * {@link org.mapstruct.ap.spi.ImmutablesAccessorNamingStrategy}, but doesn't require them.
 */
public class ProtobufAccessorNamingStrategy extends DefaultAccessorNamingStrategy {

    /**
     * An expected interface used to find out if a type is a protobuf message type (or a builder of one).
     */
    protected TypeMirror protobufMarkerInterface;

    /**
     * Whether Immutables is found on the classpath. If true, we assume that the counterpart for protobuf mapping are
     * Immutables-based data structures.
     */
    protected boolean isImmutables;

    @Override
    public void init(MapStructProcessingEnvironment aProcessingEnvironment) {
        super.init(aProcessingEnvironment);

        final TypeElement typeElement = elementUtils.getTypeElement("com.google.protobuf.MessageLiteOrBuilder");
        if (typeElement != null) {
            protobufMarkerInterface = typeElement.asType();
        }

        isImmutables = elementUtils.getTypeElement(ImmutablesConstants.IMMUTABLE_FQN) != null;
    }

    /**
     * Recursively checks whether the given {@link TypeElement} is a protobuf message type (or a builder of one).
     *
     * @param aType the type to check
     * @return true if it's a protobuf message type, false otherwise
     */
    private boolean isProtobufGeneratedMessage(TypeElement aType) {
        // Check the interfaces first
        for (final TypeMirror implementedInterface : aType.getInterfaces()) {
            if (implementedInterface.toString().startsWith("com.google.protobuf.MessageLiteOrBuilder")) {
                return true;
            } else if (implementedInterface instanceof DeclaredType) {
                if (isProtobufGeneratedMessage((TypeElement) ((DeclaredType) implementedInterface).asElement())) {
                    return true;
                }
            }
        }

        // If no match was found, check the superclasses' interfaces recursively
        final TypeMirror superType = aType.getSuperclass();
        if (superType instanceof DeclaredType) {
            return isProtobufGeneratedMessage((TypeElement) ((DeclaredType) superType).asElement());
        }

        return false;
    }

    /**
     * These are purely internal methods generated into protobuf classes. They can be entirely ignored when mapping.
     */
    private static final Set<String> INTERNAL_PROTOBUF_METHODS = new HashSet<>(Arrays.asList(
            "clear",
            "clearField",
            "clearOneof",
            "getAllFields",
            "getAllFieldsMutable",
            "getAllFieldsRaw",
            "getDefaultInstance",
            "getDefaultInstanceForType",
            "getDescriptor",
            "getDescriptorForType",
            "getField",
            "getFieldRaw",
            "getInitializationErrorString",
            "getMemoizedSerializedSize",
            "getOneofFieldDescriptor",
            "getParserForType",
            "getRepeatedField",
            "getRepeatedFieldCount",
            "getSerializedSize",
            "getSerializingExceptionMessage",
            "getUnknownFields",
            "isInitialized",
            "mergeFrom",
            "mergeUnknownFields",
            "newBuilder",
            "newBuilderForType",
            "parseDelimitedFrom",
            "parseFrom",
            "setRepeatedField",
            "setUnknownFields"));

    /**
     * Checks whether the given method is an internal protobuf method.
     *
     * @param aMethod the method to check
     * @return true if it is an internal protobuf method, false otherwise
     */
    private boolean isInternalProtobufMethod(ExecutableElement aMethod) {
        return INTERNAL_PROTOBUF_METHODS.contains(aMethod.getSimpleName().toString());
    }

    /**
     * Checks whether the given {@link ExecutableElement} is a method from a generated protobuf message class.
     *
     * @param aMethod the method to check
     * @return true if it's from a protobuf class, false otherwise
     */
    private boolean isProtobufMethod(ExecutableElement aMethod) {
        return aMethod.getKind() == ElementKind.METHOD
                && aMethod.getEnclosingElement() != null
                && protobufMarkerInterface != null
                && typeUtils.isAssignable(aMethod.getEnclosingElement().asType(), protobufMarkerInterface);
    }

    /**
     * Checks whether the given {@link TypeElement} has a method of the provided name.
     *
     * @param aType       the type to check
     * @param aMethodName the method to check for
     * @return true if a matching method is found, false otherwise
     */
    private boolean doesHaveMethod(TypeElement aType, String aMethodName) {
        return aType.getEnclosedElements()
                .stream()
                .anyMatch(e -> e.getSimpleName().toString().equals(aMethodName));
    }

    /**
     * Protobuf message fields often have several "auxiliary accessor methods" generated for them, which relate to
     * a particular field (and thus have its name as part of their name). Which methods exist depends on the type
     * of the field, but for the purpose of mapping we must ignore all of these as they all relate to the same field.
     *
     * @param aMethod the method to check
     * @return true if it is an auxiliary accessor for a field of a protobuf message, false otherwise
     */
    private boolean isAuxiliaryProtobufPropertyAccessor(ExecutableElement aMethod) {
        if (!isProtobufMethod(aMethod)) {
            return false;
        }
        final String methodName = aMethod.getSimpleName().toString();

        if (methodName.startsWith("getOneOf") && methodName.endsWith("Case")) {
            return true;
        }

        for (String prefixCandidate : Arrays.asList("clear", "merge", "mutable", "putAll", "remove")) {
            if (methodName.startsWith(prefixCandidate)) {
                String expectedAccessor = "get" + methodName.substring(prefixCandidate.length());
                if (doesHaveMethod((TypeElement) aMethod.getEnclosingElement(), expectedAccessor)) {
                    return true;
                }
            }
        }

        for (String suffixCandidate : Arrays.asList("Bytes", "Count", "Map", "Value", "ValueList")) {
            if (methodName.endsWith(suffixCandidate)) {
                final String expectedAccessor = methodName.substring(0, methodName.length() - suffixCandidate.length());
                if (doesHaveMethod((TypeElement) aMethod.getEnclosingElement(), expectedAccessor)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checks if a given type is a list (Java or protobuf ProtocolStringList) type.
     *
     * @param aType the type to check
     * @return true if it is a list, false otherwise
     */
    private boolean isListType(TypeMirror aType) {
        final String typeString = aType.toString();
        return typeString.startsWith(List.class.getCanonicalName())
                || typeString.startsWith("com.google.protobuf.ProtocolStringList");
    }

    /**
     * Checks whether a given type is a {@link Map}.
     *
     * @param aType the type to check
     * @return true if it is a map, false otherwise
     */
    private boolean isMapType(TypeMirror aType) {
        return aType.toString().startsWith(Map.class.getCanonicalName());
    }

    /**
     * Checks if a given type is a {@link java.util.Map.Entry}.
     *
     * @param aType the type to check
     * @return true if it is an entry, false otherwise
     */
    private boolean isMapEntryType(TypeMirror aType) {
        return aType.toString().startsWith(Map.Entry.class.getCanonicalName());
    }

    /**
     * Checks whether a given method is an accessor to a mutable map.
     *
     * @param aMethod the method to check
     * @return true if it is a mutable map accessor, false otherwise
     */
    private boolean isMutableMapAccessor(ExecutableElement aMethod) {
        return aMethod.getSimpleName().toString().startsWith("getMutable") && isMapType(aMethod.getReturnType());
    }

    /**
     * Checks whether a given method is an accessor to an immutable map.
     *
     * @param aMethod the method to check
     * @return true if it is an immutable map accessor, false otherwise
     */
    private boolean isImmutableMapAccessor(ExecutableElement aMethod) {
        final String methodName = aMethod.getSimpleName().toString();
        return methodName.startsWith("get")
                && !methodName.startsWith("getMutable")
                && isMapType(aMethod.getReturnType())
                && (!methodName.endsWith("Map") || doesHaveMethod((TypeElement) aMethod.getEnclosingElement(), methodName + "Map"));
    }

    /**
     * Checks whether a given method is a getter for a list.
     *
     * @param aMethod the method to check
     * @return true if it is a list getter, false otherwise
     */
    private boolean isListGetter(ExecutableElement aMethod) {
        return aMethod.getSimpleName().toString().startsWith("get") && isListType(aMethod.getReturnType());
    }

    /**
     * Checks whether a given method is a setter for a list.
     *
     * @param aMethod the method to check
     * @return true if it is a list setter, false otherwise
     */
    private boolean isListSetter(ExecutableElement aMethod) {
        return aMethod.getSimpleName().toString().startsWith("set")
                && aMethod.getParameters().size() == 1
                && isListType(aMethod.getParameters().get(0).asType());
    }

    /**
     * Checks whether a given method is a putter for a map value.
     *
     * @param aMethod the method to check
     * @return true if it is a map value putter, false otherwise
     */
    private boolean isMapValuePutter(ExecutableElement aMethod) {
        return aMethod.getSimpleName().toString().startsWith("put") && aMethod.getParameters().size() == 2;
    }

    /**
     * Checks whether a given method is a putter for a map entry.
     *
     * @param aMethod the method to check
     * @return true if it is a map entry putter, false otherwise
     */
    private boolean isMapEntryPutter(ExecutableElement aMethod) {
        return aMethod.getSimpleName().toString().startsWith("put")
                && aMethod.getParameters().size() == 1
                && isMapEntryType(aMethod.getParameters().get(0).asType());
    }

    /**
     * Checks whether a given method is a putAll for a map entry.
     *
     * @param aMethod the method to check
     * @return true if it is a map entry putAll, false otherwise
     */
    private boolean isMapEntryPutAll(ExecutableElement aMethod) {
        return aMethod.getSimpleName().toString().startsWith("putAll")
                && aMethod.getParameters().size() == 1
                && isMapType(aMethod.getParameters().get(0).asType());
    }

    @Override
    public boolean isGetterMethod(ExecutableElement aMethod) {
        if (isInternalProtobufMethod(aMethod) || isAuxiliaryProtobufPropertyAccessor(aMethod)) {
            return false;
        }

        final String methodName = aMethod.getSimpleName().toString();
        if (methodName.endsWith("OrBuilder") || methodName.endsWith("BuilderList")) {
            return false;
        }

        if (isMutableMapAccessor(aMethod)) {
            return true;
        } else if (isImmutableMapAccessor(aMethod)) {
            // For protobuf builder types we want to use the mutable map accessor
            final TypeElement type = (TypeElement) aMethod.getEnclosingElement();
            return !type.getSuperclass().toString().startsWith("com.google.protobuf.GeneratedMessageV3.Builder");
        }

        return super.isGetterMethod(aMethod);
    }

    @Override
    public boolean isSetterMethod(ExecutableElement aMethod) {
        if (isInternalProtobufMethod(aMethod) || isAuxiliaryProtobufPropertyAccessor(aMethod)) {
            return false;
        }
        if (isMapEntryPutAll(aMethod) || isMapEntryPutter(aMethod) || isMapValuePutter(aMethod)) {
            return false;
        }

        return super.isSetterMethod(aMethod);
    }

    @Override
    protected boolean isFluentSetter(ExecutableElement aMethod) {
        // Equivalent from ImmutablesAccessorNamingStrategy
        if (isImmutables && aMethod.getSimpleName().toString().equals("from")) {
            return false;
        }

        if (isInternalProtobufMethod(aMethod) || isAuxiliaryProtobufPropertyAccessor(aMethod)) {
            return false;
        }

        final String methodName = aMethod.getSimpleName().toString();
        if (methodName.startsWith("get")) {
            return false;
        }

        return super.isFluentSetter(aMethod);
    }

    @Override
    public boolean isAdderMethod(ExecutableElement aMethod) {
        if (isInternalProtobufMethod(aMethod) || isAuxiliaryProtobufPropertyAccessor(aMethod)) {
            return false;
        }

        return super.isAdderMethod(aMethod);
    }

    @Override
    public boolean isPresenceCheckMethod(ExecutableElement aMethod) {
        if (isInternalProtobufMethod(aMethod) || isAuxiliaryProtobufPropertyAccessor(aMethod)) {
            return false;
        }

        return super.isPresenceCheckMethod(aMethod);
    }

    @Override
    public String getElementName(ExecutableElement aMethod) {
        final String methodName = super.getElementName(aMethod);
        if (isProtobufMethod(aMethod)) {
            return Nouns.singularize(methodName);
        } else {
            return methodName;
        }
    }

    @Override
    public String getPropertyName(ExecutableElement aMethod) {
        // Protobuf list/map accessors have special naming conventions that we must "reverse" here in order to get the
        // actual property name

        final Element receiver = aMethod.getEnclosingElement();
        if (receiver != null && (receiver.getKind() == ElementKind.CLASS || receiver.getKind() == ElementKind.INTERFACE)) {
            final TypeElement type = (TypeElement) receiver;
            if (isProtobufGeneratedMessage(type)) {
                final String methodName = aMethod.getSimpleName().toString();

                if (isListGetter(aMethod) || isListSetter(aMethod)) {
                    return IntrospectorUtils.decapitalize(
                            methodName.substring("get".length(), methodName.length() - "List".length()));
                } else if (isMutableMapAccessor(aMethod)) {
                    return IntrospectorUtils.decapitalize(methodName.substring("getMutable".length()));
                } else if (isImmutableMapAccessor(aMethod)) {
                    return IntrospectorUtils.decapitalize(methodName.substring("get".length()));
                }
            }
        }

        return super.getPropertyName(aMethod);
    }

}
