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

This SPI implementation is released under the MIT license, built on GitHub and available on [Maven Central](https://search.maven.org/artifact/de.firehead/mapstruct-spi-protobuf).
Note that it's a different implementation than [entur/mapstruct-spi-protobuf](https://github.com/entur/mapstruct-spi-protobuf) which does a similar job, but was reimplemented from scratch to add support for more mapping targets, particularly org.immutables and other protobufs.

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
the enum name in snake-case. These are used to handle unknown enum values and the default "unspecified" value,
respectively. By default, this SPI implementation will map both of these to `null` in the target enum, which is usually
fine if you have a "normal" Java enum on the other side, as that will not have a value like `UNRECOGNIZED`. However, if
you are mapping to another Protobuf enum, then there is an `UNRECOGNIZED` value that the source value can be mapped to,
and due to the SPI implementation mapping both of these values to `null`, the mapping of these special values won't work
as only one of them will map to the correct other value.

Due to limitations of the SPI interface, the implementation cannot discern whether the mapping target is a Protobuf enum
or a Java enum, so it cannot automatically take this special case into account. However, there is an SPI-specific
configuration option available to disable the automatic mapping of `UNRECOGNIZED` to `null`:
`protobuf.enum.mapUnrecognizedToNull`.

If you are mapping to another Protobuf enum, you should set this option to `false`, which works just like any of
Mapstructs' own configuration options by adding a compiler parameter. In Maven, this would look for example like this:

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

If you need an example, see the mapstruct-spi-protobuf-test-proto2proto test module where this particular situation is
unit-tested!