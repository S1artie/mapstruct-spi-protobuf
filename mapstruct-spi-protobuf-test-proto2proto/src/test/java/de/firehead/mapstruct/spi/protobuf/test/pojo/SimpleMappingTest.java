/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.pojo;

import de.firehead.mapstruct.spi.protobuf.test.proto2proto.Proto2ProtoTestProtos;
import de.firehead.mapstruct.spi.protobuf.test.proto2proto.mapper.TestMapper;
import de.firehead.mapstruct.spi.protobuf.test.protos.TestProtos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleMappingTest extends AbstractMappingTest {

    @Test
    public void testSimpleMappingProtoToOtherProto() {
        final Proto2ProtoTestProtos.OtherTestProtoMessage mappedOtherProto = TestMapper.INSTANCE.mapTestProtoToOtherProto(TEST_PROTO_MESSAGE);

        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getStringField(), mappedOtherProto.getStringField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getIntField(), mappedOtherProto.getIntField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getLongField(), mappedOtherProto.getLongField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getFloatField(), mappedOtherProto.getFloatField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getDoubleField(), mappedOtherProto.getDoubleField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBooleanField(), mappedOtherProto.getBooleanField());
        Assertions.assertArrayEquals(TEST_OTHER_PROTO_MESSAGE.getBytesField().toByteArray(), mappedOtherProto.getBytesField().toByteArray());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getEnumField(), mappedOtherProto.getEnumField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getStringMapFieldMap(), mappedOtherProto.getStringMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getIntMapFieldMap(), mappedOtherProto.getIntMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getLongMapFieldMap(), mappedOtherProto.getLongMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getFloatMapFieldMap(), mappedOtherProto.getFloatMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getDoubleMapFieldMap(), mappedOtherProto.getDoubleMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBoolMapFieldMap(), mappedOtherProto.getBoolMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().size(), mappedOtherProto.getBytesMapFieldMap().size());
        for (final String key : TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().keySet()) {
            Assertions.assertArrayEquals(TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().get(key).toByteArray(), mappedOtherProto.getBytesMapFieldMap().get(key).toByteArray());
        }
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getEnumMapFieldMap(), mappedOtherProto.getEnumMapFieldMap());
    }

    @Test
    public void testSimpleMappingPojoToProto() {
        final TestProtos.TestProtoMessage mappedProto = TestMapper.INSTANCE.mapOtherProtoToProto(TEST_OTHER_PROTO_MESSAGE);

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

    @Test
    public void testUnspecifiedEnumValue() {
        Assertions.assertEquals(TestProtos.TestEnum.TEST_ENUM_UNSPECIFIED, TestMapper.INSTANCE.mapOtherEnumToEnum(Proto2ProtoTestProtos.OtherTestEnum.OTHER_TEST_ENUM_UNSPECIFIED));
        Assertions.assertEquals(Proto2ProtoTestProtos.OtherTestEnum.OTHER_TEST_ENUM_UNSPECIFIED, TestMapper.INSTANCE.mapEnumToOtherEnum(TestProtos.TestEnum.TEST_ENUM_UNSPECIFIED));
    }

}
