# Mapstruct SPI implementation for protocol buffers mapping

![Maven Central Version](https://img.shields.io/maven-central/v/de.firehead/mapstruct-spi-protobuf?link=https%3A%2F%2Fsearch.maven.org%2Fartifact%2Fde.firehead%2Fmapstruct-spi-protobuf)
![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/S1artie/mapstruct-spi-protobuf/maven.yml?link=https%3A%2F%2Fgithub.com%2FS1artie%2Fmapstruct-spi-protobuf%2Factions)

This project provides a SPI implementation for [Mapstruct](http://mapstruct.org/) to generate mapping code from protocol
buffer messages (in the form of protobuf-java objects) to the following targets:

- Plain Old Java Objects (POJOs)
- [Immutables](https://immutables.github.io/) value objects (presence of org.immutables:value dependency at generation
  time enables Immutables compatibility!)
- Java records
- other protobuf messages in the form of other protobuf-java objects (see caveat below!)

Unit tests exist to validate all of these mappings. The SPI implementation requires **Mapstruct 1.6.0+**
and **Java 1.8+** (of course if you want to map to records, Java 14+ is required).

This SPI implementation is released under the MIT license, built on GitHub and available
on [Maven Central](https://search.maven.org/artifact/de.firehead/mapstruct-spi-protobuf).
Note that it's a different implementation
than [entur/mapstruct-spi-protobuf](https://github.com/entur/mapstruct-spi-protobuf); the protobuf mapping logic was
reimplemented from scratch here with the goal of explicitly supporting more mapping targets, particularly org.immutables
and other protobufs, both of which pose some unique challenges not properly handled by the entur plugin.

The enum mapping strategy assumes that Google's enum value naming scheme is used, as described
here: https://developers.google.com/protocol-buffers/docs/style#enum

This SPI implementation also includes a [pull request](https://github.com/mapstruct/mapstruct/pull/2219) from the
Mapstruct repository that was not merged yet, but fixes a
deficiency with Mapstructs' own org.immutables support when using inner classes and @Value.Enclosing.

## Usage

Your protobuf mapping interfaces must be annotated with `@Mapper`
and `collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED`
because the protobuf classes use a builder pattern.

```java
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface XXX {
```

Include the mapstruct dependency and the annotation processor in your Maven project:

```xml
<dependencies>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.6.2</version>
    </dependency>
</dependencies>

<build>
<plugins>
    <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
            <annotationProcessorPaths>
                <path>
                    <groupId>de.firehead</groupId>
                    <artifactId>mapstruct-spi-protobuf</artifactId>
                    <version>1.1.0</version>
                </path>
            </annotationProcessorPaths>
        </configuration>
    </plugin>
</plugins>
</build>
```

Or for Gradle:

```java
implementation"org.mapstruct:mapstruct:1.6.2"
annotationProcessor"org.mapstruct:mapstruct-processor:1.6.0"
annotationProcessor"de.firehead:mapstruct-spi-protobuf:1.1.0"
```

## Protobuf-to-Protobuf mapping

**There is an important caveat with regard to Protobuf-to-Protobuf mapping when it comes to enumerations!**

Protobuf enums have two "hard-coded" values: `UNRECOGNIZED` and `_UNSPECIFIED`, with the latter typically prefixed by
the enum name in snake-case (the latter is not strictly a hard-coded value; the only thing that's hard-coded is
that the first enum value is the "default" value or "null equivalent", and it's common convention to name this specific
value `_UNSPECIFIED`).

By default, this SPI implementation will map both of these to `null` in the target enum, which is usually
fine if you have a "normal" Java enum on the other side, as that will not have a value like `UNRECOGNIZED`. However, if
you are mapping between two Protobuf enums, then there is an `UNRECOGNIZED` value on the other side that the source
value can be mapped to, and due to the SPI implementation mapping both of these values to `null`, the mapping loses
information: Mapstruct generates mapping code that happily maps `_UNSPECIFIED` to `UNRECOGNIZED` in that case - even
though of course it could map one `UNRECOGNIZED` to the other `UNRECOGNIZED` (and the `_UNSPECIFIED` to the other
`_UNSPECIFIED` as well). Here's an example from our unit tests:

```java
@Override
public TestProtos.TestEnum mapOtherEnumToEnum(Proto2ProtoTestProtos.OtherTestEnum otherTestEnum) {
    if ( otherTestEnum == null ) {
        return TestProtos.TestEnum.TEST_ENUM_UNSPECIFIED;
    }

    TestProtos.TestEnum testEnum;

    switch ( otherTestEnum ) {
        case OTHER_TEST_ENUM_UNSPECIFIED: testEnum = TestProtos.TestEnum.UNRECOGNIZED;
        break;
        case OTHER_TEST_ENUM_VALUE: testEnum = TestProtos.TestEnum.TEST_ENUM_VALUE;
        break;
        case UNRECOGNIZED: testEnum = TestProtos.TestEnum.UNRECOGNIZED;
        break;
        default: throw new IllegalArgumentException( "Unexpected enum constant: " + otherTestEnum );
    }

    return testEnum;
}
```

The mapping `case OTHER_TEST_ENUM_UNSPECIFIED: testEnum = TestProtos.TestEnum.UNRECOGNIZED;` is not what we had in
mind!

Due to limitations of the SPI interface however, the Protobuf enum mapping rule implementation cannot discern whether
the mapping target is a Protobuf enum or a Java enum, so it cannot automatically take this special case into account.
But there is an SPI-specific configuration option available to disable the automatic mapping of `UNRECOGNIZED` to
`null`: `protobuf.enum.mapUnrecognizedToNull`. If you are mapping to another Protobuf enum, you should set this option
to `false`, which works just like any of Mapstructs' own configuration options by adding a compiler parameter. In Maven,
this would look for example like this:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <annotationProcessorPaths>
            <path>
                <groupId>de.firehead</groupId>
                <artifactId>mapstruct-spi-protobuf</artifactId>
                <version>1.1.0</version>
            </path>
        </annotationProcessorPaths>
        <compilerArgs>
            <arg>-Aprotobuf.enum.mapUnrecognizedToNull=false</arg>
        </compilerArgs>
    </configuration>
</plugin>
```

With that option set to `false`, the generated mapping code will look like this:

```java
@Override
public TestProtos.TestEnum mapOtherEnumToEnum(Proto2ProtoTestProtos.OtherTestEnum otherTestEnum) {
    if ( otherTestEnum == null ) {
        return TestProtos.TestEnum.TEST_ENUM_UNSPECIFIED;
    }

    TestProtos.TestEnum testEnum;

    switch ( otherTestEnum ) {
        case OTHER_TEST_ENUM_UNSPECIFIED: testEnum = TestProtos.TestEnum.TEST_ENUM_UNSPECIFIED;
        break;
        case OTHER_TEST_ENUM_VALUE: testEnum = TestProtos.TestEnum.TEST_ENUM_VALUE;
        break;
        case UNRECOGNIZED: testEnum = TestProtos.TestEnum.UNRECOGNIZED;
        break;
        default: throw new IllegalArgumentException( "Unexpected enum constant: " + otherTestEnum );
    }

    return testEnum;
}
```

**Beware though: Performing a correct mapping is just one part of the equation - there's still an
`IllegalArgumentException` looming in the darkness!**

Protobuf considers the `UNRECOGNIZED` value to be special. Enum values are transmitted over the wire in the form of
integers, and if a value is received that does not correspond to any known enum value, the `UNRECOGNIZED` value is
basically a catch-all target for these unknown numeric values. This also means that the `UNRECOGNIZED` enum value
doesn't have a single static numeric value associated to it (the -1 value found in the Java enum is just a placeholder,
it's not what's typically received over the wire), so consequently, Protobuf enums contain the following code that
throws an exception whenever the number of an `UNRECOGNIZED` value is accessed:

```java
public final int getNumber() {
    if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
                "Can't get the number of an unknown enum value.");
    }
    return value;
}
```

This makes the `UNRECOGNIZED` value effectively un-settable into a Protobuf messages' enum field, because the fields'
setter will call `getNumber()` on the enum value, which will throw the exception. Not what we'd like to get when using
our Mapstruct-generated mapper to map a Protobuf message to another Protobuf message!

So instead of setting the `UNRECOGNIZED` value, we'll unfortunately have to do the next-best thing: NOT setting any
value at all, which effectively means that the field will have the `_UNSPECIFIED` value in the target message. This
boils down to the same logic as with Protobuf-to-Java mappings, where the `_UNSPECIFIED` value is mapped to `null`. But:
it's a bit more difficult to achieve this in Protobuf-to-Protobuf mapping. The SPI interface does not allow to generate
code that would conditionally skip setting a field based on the value to be set, so it's necessary to resort to a
`@Condition` method in the mapper interface. This method can fortunately be specified in a generic way, able to deal
with all Protobuf enums, so you'll have to worry about this once and not for every single enum added in the future.
Here's a suggestion:

```java
@org.mapstruct.Condition
protected boolean isNotUnrecognized(com.google.protobuf.ProtocolMessageEnum aProtoEnum) {
    return !"UNRECOGNIZED".equals(aProtoEnum.toString());
}
```

The resulting enum value assignments generated by Mapstruct in a Protobuf message mapping will then look something like
this:

```java
if ( isNotUnrecognized(testObject.getEnumField() ) ) {
    testProtoMessage.setEnumField( mapOtherEnumToEnum( testObject.getEnumField() ) );
}
```

Et voilá! The `UNRECOGNIZED` value is not set into the target message, and the `_UNSPECIFIED` value is retained. If you
need an example, see the mapstruct-spi-protobuf-test-proto2proto test module where this particular situation is
unit-tested!

**Note that this generic @Condition solution does NOT work for Protobuf enums in Maps!** In order to not run into the
dreaded `IllegalArgumentException` when mapping Maps that contain Protobuf enums, you'll probably not get around writing
custom mapping code specifically for each mapping case.
