/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.pojo;

import de.firehead.mapstruct.spi.protobuf.test.pojo.mapper.TestMapper;
import de.firehead.mapstruct.spi.protobuf.test.protos.TestProtos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleMappingTest extends AbstractMappingTest {

    @Test
    public void testSimpleMappingProtoToPojo() {
        final TestObject mappedPojo = TestMapper.INSTANCE.mapTestProtoToPojo(TEST_PROTO_MESSAGE);

        Assertions.assertEquals(TEST_OBJECT.getStringField(), mappedPojo.getStringField());
        Assertions.assertEquals(TEST_OBJECT.getIntField(), mappedPojo.getIntField());
        Assertions.assertEquals(TEST_OBJECT.getLongField(), mappedPojo.getLongField());
        Assertions.assertEquals(TEST_OBJECT.getFloatField(), mappedPojo.getFloatField());
        Assertions.assertEquals(TEST_OBJECT.getDoubleField(), mappedPojo.getDoubleField());
        Assertions.assertEquals(TEST_OBJECT.getBooleanField(), mappedPojo.getBooleanField());
        Assertions.assertArrayEquals(TEST_OBJECT.getBytesField(), mappedPojo.getBytesField());
        Assertions.assertEquals(TEST_OBJECT.getEnumField(), mappedPojo.getEnumField());
        Assertions.assertEquals(TEST_OBJECT.getStringMapField(), mappedPojo.getStringMapField());
        Assertions.assertEquals(TEST_OBJECT.getIntMapField(), mappedPojo.getIntMapField());
        Assertions.assertEquals(TEST_OBJECT.getLongMapField(), mappedPojo.getLongMapField());
        Assertions.assertEquals(TEST_OBJECT.getFloatMapField(), mappedPojo.getFloatMapField());
        Assertions.assertEquals(TEST_OBJECT.getDoubleMapField(), mappedPojo.getDoubleMapField());
        Assertions.assertEquals(TEST_OBJECT.getBoolMapField(), mappedPojo.getBoolMapField());
        Assertions.assertEquals(TEST_OBJECT.getBytesMapField().size(), mappedPojo.getBytesMapField().size());
        for (final String key : TEST_OBJECT.getBytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_OBJECT.getBytesMapField().get(key), mappedPojo.getBytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_OBJECT.getEnumMapField(), mappedPojo.getEnumMapField());
    }

    @Test
    public void testSimpleMappingPojoToProto() {
        final TestProtos.TestProtoMessage mappedProto = TestMapper.INSTANCE.mapTestPojoToProto(TEST_OBJECT);

        Assertions.assertEquals(TEST_PROTO_MESSAGE.getStringField(), mappedProto.getStringField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getIntField(), mappedProto.getIntField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getLongField(), mappedProto.getLongField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getFloatField(), mappedProto.getFloatField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getDoubleField(), mappedProto.getDoubleField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBooleanField(), mappedProto.getBooleanField());
        Assertions.assertArrayEquals(TEST_PROTO_MESSAGE.getBytesField().toByteArray(), mappedProto.getBytesField().toByteArray());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getEnumField(), mappedProto.getEnumField());
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
