/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.enums;

import de.firehead.mapstruct.spi.protobuf.options.ProtobufAdditionalSupportedOptionsProvider;
import org.mapstruct.MappingConstants;
import org.mapstruct.ap.spi.DefaultEnumMappingStrategy;
import org.mapstruct.ap.spi.MapStructProcessingEnvironment;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

/**
 * Enum mapping strategy implementing the common enum value name mapping suggestion from Google.
 *
 * @author Rene Schneider
 */
public class ProtobufEnumMappingStrategy extends DefaultEnumMappingStrategy {

    /**
     * Whether to automatically map the UNRECOGNIZED enum value to null.
     */
    private boolean mapUnrecognizedToNull = true;

    @Override
    public void init(MapStructProcessingEnvironment aProcessingEnvironment) {
        super.init(aProcessingEnvironment);

        mapUnrecognizedToNull = Boolean.parseBoolean(aProcessingEnvironment.getOptions().getOrDefault(ProtobufAdditionalSupportedOptionsProvider.MAP_UNRECOGNIZED_TO_NULL, Boolean.TRUE.toString()));
    }

    /**
     * The postfix used for the default value (if enum is unset).
     */
    private static final String DEFAULT_ENUM_POSTFIX = "UNSPECIFIED";

    @Override
    public String getDefaultNullEnumConstant(TypeElement anEnumType) {
        if (isProtobufEnum(anEnumType)) {
            final String prefix = upperCamelToUpperUnderscore(anEnumType.getSimpleName().toString());
            return prefix + "_" + DEFAULT_ENUM_POSTFIX;
        } else {
            return null;
        }
    }

    /**
     * The enum value if an unrecognizable input is read from a serialized proto blob.
     */
    private static final String UNPARSEABLE_ENUM_CONSTANT = "UNRECOGNIZED";

    @Override
    public String getEnumConstant(TypeElement anEnumType, String aSourceEnumValue) {
        if (isProtobufEnum(anEnumType)) {
            if (aSourceEnumValue == null) {
                return getDefaultNullEnumConstant(anEnumType);
            }
            final String enumWithoutNamePrefix = removeEnumNamePrefixFromValueIfPossible(anEnumType, aSourceEnumValue);
            if (UNPARSEABLE_ENUM_CONSTANT.equals(aSourceEnumValue)) {
                if (mapUnrecognizedToNull) {
                    return MappingConstants.NULL;
                }
            }
            if (DEFAULT_ENUM_POSTFIX.equals(enumWithoutNamePrefix)) {
                return MappingConstants.NULL;
            }
            return enumWithoutNamePrefix;
        }

        return aSourceEnumValue;
    }

    /**
     * Removes the prefix expected according to Google's enum value prefixing rules from the provided enum value, if it
     * is found to be present. If it's not present, this method will return the original value.
     *
     * @param anEnumType  the enum type from which to generate the corresponding prefix
     * @param anEnumValue the enum value to modify
     * @return the modified value or the original value if the expected prefix was not found
     */
    private String removeEnumNamePrefixFromValueIfPossible(TypeElement anEnumType, String anEnumValue) {
        final String prefix = upperCamelToUpperUnderscore(anEnumType.getSimpleName().toString());
        return anEnumValue.replace(prefix + "_", "");
    }

    /**
     * The interface signaling protobuf enums.
     */
    private static final String PROTOBUF_ENUM_INTERFACE_NAME = "com.google.protobuf.ProtocolMessageEnum";

    /**
     * The interface signaling protobuf lite enums.
     */
    private static final String PROTOBUF_LITE_ENUM_INTERFACE_NAME = "com.google.protobuf.Internal.EnumLite";

    /**
     * Checks whether the given {@link TypeElement} is a protobuf enum.
     *
     * @param anEnumType the enum type to check
     * @return true if it's a protobuf enum, false otherwise
     */
    private boolean isProtobufEnum(TypeElement anEnumType) {
        for (final TypeMirror implementedInterface : anEnumType.getInterfaces()) {
            final String implementedInterfaceName = implementedInterface.toString();
            if (PROTOBUF_ENUM_INTERFACE_NAME.equals(implementedInterfaceName)
                    || PROTOBUF_LITE_ENUM_INTERFACE_NAME.equals(implementedInterfaceName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Converts upper camel case to upper underscore case.
     *
     * @param anInput the upper camel case input
     * @return the upper underscore output
     */
    private static String upperCamelToUpperUnderscore(String anInput) {
        // Regular expression to find uppercase letters
        final String regex = "([a-z])([A-Z]+)";
        // Replacement pattern to add underscore before uppercase letters
        final String replacement = "$1_$2";

        final String result = anInput.replaceAll(regex, replacement);

        return result.toUpperCase();
    }

}
