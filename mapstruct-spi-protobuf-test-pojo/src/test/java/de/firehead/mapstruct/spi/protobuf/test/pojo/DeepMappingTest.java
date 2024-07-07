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

import java.util.Collections;

public class DeepMappingTest extends AbstractMappingTest {

    private static final DeepTestObject DEEP_TEST_OBJECT = new DeepTestObject();

    static {
        DEEP_TEST_OBJECT.setTestProtoMessagePlain(TEST_OBJECT);
        DEEP_TEST_OBJECT.setTestProtoMessageList(Collections.singletonList(TEST_OBJECT));
        DEEP_TEST_OBJECT.setTestProtoMessageMap(Collections.singletonMap("key1", TEST_OBJECT));
    }

    private static final TestProtos.DeepTestProtoMessage DEEP_TEST_PROTO_MESSAGE = TestProtos.DeepTestProtoMessage.newBuilder()
            .setTestProtoMessagePlain(TEST_PROTO_MESSAGE)
            .addTestProtoMessageList(TEST_PROTO_MESSAGE)
            .putTestProtoMessageMap("key1", TEST_PROTO_MESSAGE)
            .build();


    @Test
    public void testDeepMappingProtoToPojo() {
        final DeepTestObject mappedPojo = TestMapper.INSTANCE.mapDeepTestProtoToPojo(DEEP_TEST_PROTO_MESSAGE);

        // Test testProtoMessage
        Assertions.assertEquals(TEST_OBJECT.getStringField(), mappedPojo.getTestProtoMessagePlain().getStringField());
        Assertions.assertEquals(TEST_OBJECT.getIntField(), mappedPojo.getTestProtoMessagePlain().getIntField());
        Assertions.assertEquals(TEST_OBJECT.getLongField(), mappedPojo.getTestProtoMessagePlain().getLongField());
        Assertions.assertEquals(TEST_OBJECT.getFloatField(), mappedPojo.getTestProtoMessagePlain().getFloatField());
        Assertions.assertEquals(TEST_OBJECT.getDoubleField(), mappedPojo.getTestProtoMessagePlain().getDoubleField());
        Assertions.assertEquals(TEST_OBJECT.getBooleanField(), mappedPojo.getTestProtoMessagePlain().getBooleanField());
        Assertions.assertArrayEquals(TEST_OBJECT.getBytesField(), mappedPojo.getTestProtoMessagePlain().getBytesField());
        Assertions.assertEquals(TEST_OBJECT.getEnumField(), mappedPojo.getTestProtoMessagePlain().getEnumField());
        Assertions.assertEquals(TEST_OBJECT.getStringMapField(), mappedPojo.getTestProtoMessagePlain().getStringMapField());
        Assertions.assertEquals(TEST_OBJECT.getIntMapField(), mappedPojo.getTestProtoMessagePlain().getIntMapField());
        Assertions.assertEquals(TEST_OBJECT.getLongMapField(), mappedPojo.getTestProtoMessagePlain().getLongMapField());
        Assertions.assertEquals(TEST_OBJECT.getFloatMapField(), mappedPojo.getTestProtoMessagePlain().getFloatMapField());
        Assertions.assertEquals(TEST_OBJECT.getDoubleMapField(), mappedPojo.getTestProtoMessagePlain().getDoubleMapField());
        Assertions.assertEquals(TEST_OBJECT.getBoolMapField(), mappedPojo.getTestProtoMessagePlain().getBoolMapField());
        Assertions.assertEquals(TEST_OBJECT.getBytesMapField().size(), mappedPojo.getTestProtoMessagePlain().getBytesMapField().size());
        for (final String key : TEST_OBJECT.getBytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_OBJECT.getBytesMapField().get(key), mappedPojo.getTestProtoMessagePlain().getBytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_OBJECT.getEnumMapField(), mappedPojo.getTestProtoMessagePlain().getEnumMapField());

        // Test testProtoMessageList
        Assertions.assertEquals(1, mappedPojo.getTestProtoMessageList().size());
        Assertions.assertEquals(TEST_OBJECT.getStringField(), mappedPojo.getTestProtoMessageList().get(0).getStringField());
        Assertions.assertEquals(TEST_OBJECT.getIntField(), mappedPojo.getTestProtoMessageList().get(0).getIntField());
        Assertions.assertEquals(TEST_OBJECT.getLongField(), mappedPojo.getTestProtoMessageList().get(0).getLongField());
        Assertions.assertEquals(TEST_OBJECT.getFloatField(), mappedPojo.getTestProtoMessageList().get(0).getFloatField());
        Assertions.assertEquals(TEST_OBJECT.getDoubleField(), mappedPojo.getTestProtoMessageList().get(0).getDoubleField());
        Assertions.assertEquals(TEST_OBJECT.getBooleanField(), mappedPojo.getTestProtoMessageList().get(0).getBooleanField());
        Assertions.assertArrayEquals(TEST_OBJECT.getBytesField(), mappedPojo.getTestProtoMessageList().get(0).getBytesField());
        Assertions.assertEquals(TEST_OBJECT.getEnumField(), mappedPojo.getTestProtoMessageList().get(0).getEnumField());
        Assertions.assertEquals(TEST_OBJECT.getStringMapField(), mappedPojo.getTestProtoMessageList().get(0).getStringMapField());
        Assertions.assertEquals(TEST_OBJECT.getIntMapField(), mappedPojo.getTestProtoMessageList().get(0).getIntMapField());
        Assertions.assertEquals(TEST_OBJECT.getLongMapField(), mappedPojo.getTestProtoMessageList().get(0).getLongMapField());
        Assertions.assertEquals(TEST_OBJECT.getFloatMapField(), mappedPojo.getTestProtoMessageList().get(0).getFloatMapField());
        Assertions.assertEquals(TEST_OBJECT.getDoubleMapField(), mappedPojo.getTestProtoMessageList().get(0).getDoubleMapField());
        Assertions.assertEquals(TEST_OBJECT.getBoolMapField(), mappedPojo.getTestProtoMessageList().get(0).getBoolMapField());
        Assertions.assertEquals(TEST_OBJECT.getBytesMapField().size(), mappedPojo.getTestProtoMessageList().get(0).getBytesMapField().size());
        for (final String key : TEST_OBJECT.getBytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_OBJECT.getBytesMapField().get(key), mappedPojo.getTestProtoMessageList().get(0).getBytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_OBJECT.getEnumMapField(), mappedPojo.getTestProtoMessageList().get(0).getEnumMapField());

        // Test testProtoMessageMap
        Assertions.assertEquals(1, mappedPojo.getTestProtoMessageMap().size());
        Assertions.assertEquals(TEST_OBJECT.getStringField(), mappedPojo.getTestProtoMessageMap().get("key1").getStringField());
        Assertions.assertEquals(TEST_OBJECT.getIntField(), mappedPojo.getTestProtoMessageMap().get("key1").getIntField());
        Assertions.assertEquals(TEST_OBJECT.getLongField(), mappedPojo.getTestProtoMessageMap().get("key1").getLongField());
        Assertions.assertEquals(TEST_OBJECT.getFloatField(), mappedPojo.getTestProtoMessageMap().get("key1").getFloatField());
        Assertions.assertEquals(TEST_OBJECT.getDoubleField(), mappedPojo.getTestProtoMessageMap().get("key1").getDoubleField());
        Assertions.assertEquals(TEST_OBJECT.getBooleanField(), mappedPojo.getTestProtoMessageMap().get("key1").getBooleanField());
        Assertions.assertArrayEquals(TEST_OBJECT.getBytesField(), mappedPojo.getTestProtoMessageMap().get("key1").getBytesField());
        Assertions.assertEquals(TEST_OBJECT.getEnumField(), mappedPojo.getTestProtoMessageMap().get("key1").getEnumField());
        Assertions.assertEquals(TEST_OBJECT.getStringMapField(), mappedPojo.getTestProtoMessageMap().get("key1").getStringMapField());
        Assertions.assertEquals(TEST_OBJECT.getIntMapField(), mappedPojo.getTestProtoMessageMap().get("key1").getIntMapField());
        Assertions.assertEquals(TEST_OBJECT.getLongMapField(), mappedPojo.getTestProtoMessageMap().get("key1").getLongMapField());
        Assertions.assertEquals(TEST_OBJECT.getFloatMapField(), mappedPojo.getTestProtoMessageMap().get("key1").getFloatMapField());
        Assertions.assertEquals(TEST_OBJECT.getDoubleMapField(), mappedPojo.getTestProtoMessageMap().get("key1").getDoubleMapField());
        Assertions.assertEquals(TEST_OBJECT.getBoolMapField(), mappedPojo.getTestProtoMessageMap().get("key1").getBoolMapField());
        Assertions.assertEquals(TEST_OBJECT.getBytesMapField().size(), mappedPojo.getTestProtoMessageMap().get("key1").getBytesMapField().size());
        for (final String key : TEST_OBJECT.getBytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_OBJECT.getBytesMapField().get(key), mappedPojo.getTestProtoMessageMap().get("key1").getBytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_OBJECT.getEnumMapField(), mappedPojo.getTestProtoMessageMap().get("key1").getEnumMapField());
    }

    @Test
    public void testDeepMappingPojoToProto() {
        final TestProtos.DeepTestProtoMessage mappedProto = TestMapper.INSTANCE.mapDeepTestPojoToProto(DEEP_TEST_OBJECT);

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
