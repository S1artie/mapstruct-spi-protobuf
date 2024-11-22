/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.immutables;

import de.firehead.mapstruct.spi.protobuf.test.immutables.mapper.TestMapper;
import de.firehead.mapstruct.spi.protobuf.test.protos.TestProtos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleMappingTest extends AbstractMappingTest {

    @Test
    public void testSimpleMappingProtoToImmutable() {
        final TestImmutableObject mappedImmutable = TestMapper.INSTANCE.mapTestProtoToImmutable(TEST_PROTO_MESSAGE);

        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getStringField(), mappedImmutable.getStringField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getIntField(), mappedImmutable.getIntField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getLongField(), mappedImmutable.getLongField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getFloatField(), mappedImmutable.getFloatField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getDoubleField(), mappedImmutable.getDoubleField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBooleanField(), mappedImmutable.getBooleanField());
        Assertions.assertArrayEquals(TEST_IMMUTABLE_OBJECT.getBytesField(), mappedImmutable.getBytesField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getEnumField(), mappedImmutable.getEnumField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getEnumWithoutPrefixesField(), mappedImmutable.getEnumWithoutPrefixesField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getStringMapField(), mappedImmutable.getStringMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getIntMapField(), mappedImmutable.getIntMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getLongMapField(), mappedImmutable.getLongMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getFloatMapField(), mappedImmutable.getFloatMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getDoubleMapField(), mappedImmutable.getDoubleMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBoolMapField(), mappedImmutable.getBoolMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBytesMapField().size(), mappedImmutable.getBytesMapField().size());
        for (final String key : TEST_IMMUTABLE_OBJECT.getBytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_IMMUTABLE_OBJECT.getBytesMapField().get(key), mappedImmutable.getBytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getEnumMapField(), mappedImmutable.getEnumMapField());
    }

    @Test
    public void testSimpleMappingImmutableToProto() {
        final TestProtos.TestProtoMessage mappedProto = TestMapper.INSTANCE.mapTestImmutableToProto(TEST_IMMUTABLE_OBJECT);

        Assertions.assertEquals(TEST_PROTO_MESSAGE.getStringField(), mappedProto.getStringField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getIntField(), mappedProto.getIntField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getLongField(), mappedProto.getLongField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getFloatField(), mappedProto.getFloatField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getDoubleField(), mappedProto.getDoubleField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBooleanField(), mappedProto.getBooleanField());
        Assertions.assertArrayEquals(TEST_PROTO_MESSAGE.getBytesField().toByteArray(), mappedProto.getBytesField().toByteArray());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getEnumField(), mappedProto.getEnumField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getEnumWithoutPrefixesField(), mappedProto.getEnumWithoutPrefixesField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getStringMapFieldMap(), mappedProto.getStringMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getIntMapFieldMap(), mappedProto.getIntMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getLongMapFieldMap(), mappedProto.getLongMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getFloatMapFieldMap(), mappedProto.getFloatMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getDoubleMapFieldMap(), mappedProto.getDoubleMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBoolMapFieldMap(), mappedProto.getBoolMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBytesMapFieldMap().size(), mappedProto.getBytesMapFieldMap().size());
        for (final String key : TEST_PROTO_MESSAGE.getBytesMapFieldMap().keySet()) {
            Assertions.assertArrayEquals(TEST_PROTO_MESSAGE.getBytesMapFieldMap().get(key).toByteArray(), mappedProto.getBytesMapFieldMap().get(key).toByteArray());
        }
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getEnumMapFieldMap(), mappedProto.getEnumMapFieldMap());
    }

}
