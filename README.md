# Mapstruct SPI implementation for protocol buffers mapping

This project provides a SPI implementation for [Mapstruct](http://mapstruct.org/) to generate mapping code from protocol
buffers to the following targets:

- Plain Old Java Objects (POJOs)
- [Immutables](https://immutables.github.io/) value objects
- Java records

Unit tests exist to validate all of these mappings. The SPI implementation generally requires Mapstruct 1.5.5 and Java
1.8+ (of course if you want to map to records, Java 14+ is required).

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
        <version>${org.mapstruct.version}</version>
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
                    <version>1.0.0</version>
                </path>
            </annotationProcessorPaths>
        </configuration>
    </plugin>
</plugins>
</build>

```

Or for Gradle:

```java

implementation"org.mapstruct:mapstruct:${mapstructVersion}"
annotationProcessor"org.mapstruct:mapstruct-processor:${mapstructVersion}"
annotationProcessor"de.firehead:mapstruct-spi-protobuf:1.0.0"

```

