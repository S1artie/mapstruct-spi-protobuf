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

public class DeepMappingTest extends AbstractMappingTest {

    private static final Proto2ProtoTestProtos.OtherDeepTestProtoMessage PROTO_2_PROTO_DEEP_TEST_PROTO_MESSAGE = Proto2ProtoTestProtos.OtherDeepTestProtoMessage.newBuilder()
            .setTestProtoMessagePlain(TEST_OTHER_PROTO_MESSAGE)
            .addTestProtoMessageList(TEST_OTHER_PROTO_MESSAGE)
            .putTestProtoMessageMap("key1", TEST_OTHER_PROTO_MESSAGE)
            .build();

    private static final TestProtos.DeepTestProtoMessage DEEP_TEST_PROTO_MESSAGE = TestProtos.DeepTestProtoMessage.newBuilder()
            .setTestProtoMessagePlain(TEST_PROTO_MESSAGE)
            .addTestProtoMessageList(TEST_PROTO_MESSAGE)
            .putTestProtoMessageMap("key1", TEST_PROTO_MESSAGE)
            .build();

    @Test
    public void testDeepMappingProtoToOtherProto() {
        final Proto2ProtoTestProtos.OtherDeepTestProtoMessage mappedOtherProto = TestMapper.INSTANCE.mapDeepTestProtoToOtherProto(DEEP_TEST_PROTO_MESSAGE);

        // Test testProtoMessage
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getStringField(), mappedOtherProto.getTestProtoMessagePlain().getStringField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getIntField(), mappedOtherProto.getTestProtoMessagePlain().getIntField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getLongField(), mappedOtherProto.getTestProtoMessagePlain().getLongField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getFloatField(), mappedOtherProto.getTestProtoMessagePlain().getFloatField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getDoubleField(), mappedOtherProto.getTestProtoMessagePlain().getDoubleField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBooleanField(), mappedOtherProto.getTestProtoMessagePlain().getBooleanField());
        Assertions.assertArrayEquals(TEST_OTHER_PROTO_MESSAGE.getBytesField().toByteArray(), mappedOtherProto.getTestProtoMessagePlain().getBytesField().toByteArray());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getEnumField(), mappedOtherProto.getTestProtoMessagePlain().getEnumField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getStringMapFieldMap(), mappedOtherProto.getTestProtoMessagePlain().getStringMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getIntMapFieldMap(), mappedOtherProto.getTestProtoMessagePlain().getIntMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getLongMapFieldMap(), mappedOtherProto.getTestProtoMessagePlain().getLongMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getFloatMapFieldMap(), mappedOtherProto.getTestProtoMessagePlain().getFloatMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getDoubleMapFieldMap(), mappedOtherProto.getTestProtoMessagePlain().getDoubleMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBoolMapFieldMap(), mappedOtherProto.getTestProtoMessagePlain().getBoolMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().size(), mappedOtherProto.getTestProtoMessagePlain().getBytesMapFieldMap().size());
        for (final String key : TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().keySet()) {
            Assertions.assertArrayEquals(TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().get(key).toByteArray(), mappedOtherProto.getTestProtoMessagePlain().getBytesMapFieldMap().get(key).toByteArray());
        }
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getEnumMapFieldMap(), mappedOtherProto.getTestProtoMessagePlain().getEnumMapFieldMap());

        // Test testProtoMessageList
        Assertions.assertEquals(1, mappedOtherProto.getTestProtoMessageListList().size());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getStringField(), mappedOtherProto.getTestProtoMessageListList().get(0).getStringField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getIntField(), mappedOtherProto.getTestProtoMessageListList().get(0).getIntField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getLongField(), mappedOtherProto.getTestProtoMessageListList().get(0).getLongField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getFloatField(), mappedOtherProto.getTestProtoMessageListList().get(0).getFloatField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getDoubleField(), mappedOtherProto.getTestProtoMessageListList().get(0).getDoubleField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBooleanField(), mappedOtherProto.getTestProtoMessageListList().get(0).getBooleanField());
        Assertions.assertArrayEquals(TEST_OTHER_PROTO_MESSAGE.getBytesField().toByteArray(), mappedOtherProto.getTestProtoMessageListList().get(0).getBytesField().toByteArray());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getEnumField(), mappedOtherProto.getTestProtoMessageListList().get(0).getEnumField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getStringMapFieldMap(), mappedOtherProto.getTestProtoMessageListList().get(0).getStringMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getIntMapFieldMap(), mappedOtherProto.getTestProtoMessageListList().get(0).getIntMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getLongMapFieldMap(), mappedOtherProto.getTestProtoMessageListList().get(0).getLongMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getFloatMapFieldMap(), mappedOtherProto.getTestProtoMessageListList().get(0).getFloatMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getDoubleMapFieldMap(), mappedOtherProto.getTestProtoMessageListList().get(0).getDoubleMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBoolMapFieldMap(), mappedOtherProto.getTestProtoMessageListList().get(0).getBoolMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().size(), mappedOtherProto.getTestProtoMessageListList().get(0).getBytesMapFieldMap().size());
        for (final String key : TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().keySet()) {
            Assertions.assertArrayEquals(TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().get(key).toByteArray(), mappedOtherProto.getTestProtoMessageListList().get(0).getBytesMapFieldMap().get(key).toByteArray());
        }
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getEnumMapFieldMap(), mappedOtherProto.getTestProtoMessageListList().get(0).getEnumMapFieldMap());

        // Test testProtoMessageMap
        Assertions.assertEquals(1, mappedOtherProto.getTestProtoMessageMapMap().size());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getStringField(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getStringField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getIntField(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getIntField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getLongField(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getLongField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getFloatField(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getFloatField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getDoubleField(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getDoubleField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBooleanField(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getBooleanField());
        Assertions.assertArrayEquals(TEST_OTHER_PROTO_MESSAGE.getBytesField().toByteArray(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getBytesField().toByteArray());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getEnumField(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getEnumField());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getStringMapFieldMap(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getStringMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getIntMapFieldMap(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getIntMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getLongMapFieldMap(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getLongMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getFloatMapFieldMap(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getFloatMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getDoubleMapFieldMap(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getDoubleMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBoolMapFieldMap(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getBoolMapFieldMap());
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().size(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getBytesMapFieldMap().size());
        for (final String key : TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().keySet()) {
            Assertions.assertArrayEquals(TEST_OTHER_PROTO_MESSAGE.getBytesMapFieldMap().get(key).toByteArray(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getBytesMapFieldMap().get(key).toByteArray());
        }
        Assertions.assertEquals(TEST_OTHER_PROTO_MESSAGE.getEnumMapFieldMap(), mappedOtherProto.getTestProtoMessageMapMap().get("key1").getEnumMapFieldMap());
    }

    @Test
    public void testDeepMappingOtherProtoToProto() {
        final TestProtos.DeepTestProtoMessage mappedProto = TestMapper.INSTANCE.mapDeepTestOtherProtoToProto(PROTO_2_PROTO_DEEP_TEST_PROTO_MESSAGE);

        // Test testProtoMessage
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getStringField(), mappedProto.getTestProtoMessagePlain().getStringField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getIntField(), mappedProto.getTestProtoMessagePlain().getIntField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getLongField(), mappedProto.getTestProtoMessagePlain().getLongField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getFloatField(), mappedProto.getTestProtoMessagePlain().getFloatField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getDoubleField(), mappedProto.getTestProtoMessagePlain().getDoubleField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBooleanField(), mappedProto.getTestProtoMessagePlain().getBooleanField());
        Assertions.assertArrayEquals(TEST_PROTO_MESSAGE.getBytesField().toByteArray(), mappedProto.getTestProtoMessagePlain().getBytesField().toByteArray());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getEnumField(), mappedProto.getTestProtoMessagePlain().getEnumField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getStringMapFieldMap(), mappedProto.getTestProtoMessagePlain().getStringMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getIntMapFieldMap(), mappedProto.getTestProtoMessagePlain().getIntMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getLongMapFieldMap(), mappedProto.getTestProtoMessagePlain().getLongMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getFloatMapFieldMap(), mappedProto.getTestProtoMessagePlain().getFloatMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getDoubleMapFieldMap(), mappedProto.getTestProtoMessagePlain().getDoubleMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBoolMapFieldMap(), mappedProto.getTestProtoMessagePlain().getBoolMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBytesMapFieldMap().size(), mappedProto.getTestProtoMessagePlain().getBytesMapFieldMap().size());
        for (final String key : TEST_PROTO_MESSAGE.getBytesMapFieldMap().keySet()) {
            Assertions.assertArrayEquals(TEST_PROTO_MESSAGE.getBytesMapFieldMap().get(key).toByteArray(), mappedProto.getTestProtoMessagePlain().getBytesMapFieldMap().get(key).toByteArray());
        }
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getEnumMapFieldMap(), mappedProto.getTestProtoMessagePlain().getEnumMapFieldMap());

        // Test testProtoMessageList
        Assertions.assertEquals(1, mappedProto.getTestProtoMessageListList().size());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getStringField(), mappedProto.getTestProtoMessageListList().get(0).getStringField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getIntField(), mappedProto.getTestProtoMessageListList().get(0).getIntField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getLongField(), mappedProto.getTestProtoMessageListList().get(0).getLongField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getFloatField(), mappedProto.getTestProtoMessageListList().get(0).getFloatField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getDoubleField(), mappedProto.getTestProtoMessageListList().get(0).getDoubleField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBooleanField(), mappedProto.getTestProtoMessageListList().get(0).getBooleanField());
        Assertions.assertArrayEquals(TEST_PROTO_MESSAGE.getBytesField().toByteArray(), mappedProto.getTestProtoMessageListList().get(0).getBytesField().toByteArray());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getEnumField(), mappedProto.getTestProtoMessageListList().get(0).getEnumField());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getStringMapFieldMap(), mappedProto.getTestProtoMessageListList().get(0).getStringMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getIntMapFieldMap(), mappedProto.getTestProtoMessageListList().get(0).getIntMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getLongMapFieldMap(), mappedProto.getTestProtoMessageListList().get(0).getLongMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getFloatMapFieldMap(), mappedProto.getTestProtoMessageListList().get(0).getFloatMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getDoubleMapFieldMap(), mappedProto.getTestProtoMessageListList().get(0).getDoubleMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBoolMapFieldMap(), mappedProto.getTestProtoMessageListList().get(0).getBoolMapFieldMap());
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getBytesMapFieldMap().size(), mappedProto.getTestProtoMessageListList().get(0).getBytesMapFieldMap().size());
        for (final String key : TEST_PROTO_MESSAGE.getBytesMapFieldMap().keySet()) {
            Assertions.assertArrayEquals(TEST_PROTO_MESSAGE.getBytesMapFieldMap().get(key).toByteArray(), mappedProto.getTestProtoMessageListList().get(0).getBytesMapFieldMap().get(key).toByteArray());
        }
        Assertions.assertEquals(TEST_PROTO_MESSAGE.getEnumMapFieldMap(), mappedProto.getTestProtoMessageListList().get(0).getEnumMapFieldMap());
    }

}
