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

public class DeepMappingTest extends AbstractMappingTest {

    private static final DeepTestImmutableObject DEEP_TEST_IMMUTABLE_OBJECT = ImmutableDeepTestImmutableObject.builder()
            .testProtoMessagePlain(TEST_IMMUTABLE_OBJECT)
            .addTestProtoMessageList(TEST_IMMUTABLE_OBJECT)
            .putTestProtoMessageMap("key1", TEST_IMMUTABLE_OBJECT)
            .build();

    private static final TestProtos.DeepTestProtoMessage DEEP_TEST_PROTO_MESSAGE = TestProtos.DeepTestProtoMessage.newBuilder()
            .setTestProtoMessagePlain(TEST_PROTO_MESSAGE)
            .addTestProtoMessageList(TEST_PROTO_MESSAGE)
            .putTestProtoMessageMap("key1", TEST_PROTO_MESSAGE)
            .build();


    @Test
    public void testDeepMappingProtoToImmutable() {
        final DeepTestImmutableObject mappedImmutable = TestMapper.INSTANCE.mapDeepTestProtoToImmutable(DEEP_TEST_PROTO_MESSAGE);

        // Test testProtoMessage
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getStringField(), mappedImmutable.getTestProtoMessagePlain().getStringField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getIntField(), mappedImmutable.getTestProtoMessagePlain().getIntField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getLongField(), mappedImmutable.getTestProtoMessagePlain().getLongField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getFloatField(), mappedImmutable.getTestProtoMessagePlain().getFloatField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getDoubleField(), mappedImmutable.getTestProtoMessagePlain().getDoubleField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBooleanField(), mappedImmutable.getTestProtoMessagePlain().getBooleanField());
        Assertions.assertArrayEquals(TEST_IMMUTABLE_OBJECT.getBytesField(), mappedImmutable.getTestProtoMessagePlain().getBytesField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getEnumField(), mappedImmutable.getTestProtoMessagePlain().getEnumField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getStringMapField(), mappedImmutable.getTestProtoMessagePlain().getStringMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getIntMapField(), mappedImmutable.getTestProtoMessagePlain().getIntMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getLongMapField(), mappedImmutable.getTestProtoMessagePlain().getLongMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getFloatMapField(), mappedImmutable.getTestProtoMessagePlain().getFloatMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getDoubleMapField(), mappedImmutable.getTestProtoMessagePlain().getDoubleMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBoolMapField(), mappedImmutable.getTestProtoMessagePlain().getBoolMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBytesMapField().size(), mappedImmutable.getTestProtoMessagePlain().getBytesMapField().size());
        for (final String key : TEST_IMMUTABLE_OBJECT.getBytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_IMMUTABLE_OBJECT.getBytesMapField().get(key), mappedImmutable.getTestProtoMessagePlain().getBytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getEnumMapField(), mappedImmutable.getTestProtoMessagePlain().getEnumMapField());

        // Test testProtoMessageList
        Assertions.assertEquals(1, mappedImmutable.getTestProtoMessageList().size());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getStringField(), mappedImmutable.getTestProtoMessageList().get(0).getStringField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getIntField(), mappedImmutable.getTestProtoMessageList().get(0).getIntField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getLongField(), mappedImmutable.getTestProtoMessageList().get(0).getLongField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getFloatField(), mappedImmutable.getTestProtoMessageList().get(0).getFloatField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getDoubleField(), mappedImmutable.getTestProtoMessageList().get(0).getDoubleField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBooleanField(), mappedImmutable.getTestProtoMessageList().get(0).getBooleanField());
        Assertions.assertArrayEquals(TEST_IMMUTABLE_OBJECT.getBytesField(), mappedImmutable.getTestProtoMessageList().get(0).getBytesField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getEnumField(), mappedImmutable.getTestProtoMessageList().get(0).getEnumField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getStringMapField(), mappedImmutable.getTestProtoMessageList().get(0).getStringMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getIntMapField(), mappedImmutable.getTestProtoMessageList().get(0).getIntMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getLongMapField(), mappedImmutable.getTestProtoMessageList().get(0).getLongMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getFloatMapField(), mappedImmutable.getTestProtoMessageList().get(0).getFloatMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getDoubleMapField(), mappedImmutable.getTestProtoMessageList().get(0).getDoubleMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBoolMapField(), mappedImmutable.getTestProtoMessageList().get(0).getBoolMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBytesMapField().size(), mappedImmutable.getTestProtoMessageList().get(0).getBytesMapField().size());
        for (final String key : TEST_IMMUTABLE_OBJECT.getBytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_IMMUTABLE_OBJECT.getBytesMapField().get(key), mappedImmutable.getTestProtoMessageList().get(0).getBytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getEnumMapField(), mappedImmutable.getTestProtoMessageList().get(0).getEnumMapField());

        // Test testProtoMessageMap
        Assertions.assertEquals(1, mappedImmutable.getTestProtoMessageMap().size());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getStringField(), mappedImmutable.getTestProtoMessageMap().get("key1").getStringField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getIntField(), mappedImmutable.getTestProtoMessageMap().get("key1").getIntField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getLongField(), mappedImmutable.getTestProtoMessageMap().get("key1").getLongField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getFloatField(), mappedImmutable.getTestProtoMessageMap().get("key1").getFloatField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getDoubleField(), mappedImmutable.getTestProtoMessageMap().get("key1").getDoubleField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBooleanField(), mappedImmutable.getTestProtoMessageMap().get("key1").getBooleanField());
        Assertions.assertArrayEquals(TEST_IMMUTABLE_OBJECT.getBytesField(), mappedImmutable.getTestProtoMessageMap().get("key1").getBytesField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getEnumField(), mappedImmutable.getTestProtoMessageMap().get("key1").getEnumField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getStringMapField(), mappedImmutable.getTestProtoMessageMap().get("key1").getStringMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getIntMapField(), mappedImmutable.getTestProtoMessageMap().get("key1").getIntMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getLongMapField(), mappedImmutable.getTestProtoMessageMap().get("key1").getLongMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getFloatMapField(), mappedImmutable.getTestProtoMessageMap().get("key1").getFloatMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getDoubleMapField(), mappedImmutable.getTestProtoMessageMap().get("key1").getDoubleMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBoolMapField(), mappedImmutable.getTestProtoMessageMap().get("key1").getBoolMapField());
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getBytesMapField().size(), mappedImmutable.getTestProtoMessageMap().get("key1").getBytesMapField().size());
        for (final String key : TEST_IMMUTABLE_OBJECT.getBytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_IMMUTABLE_OBJECT.getBytesMapField().get(key), mappedImmutable.getTestProtoMessageMap().get("key1").getBytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_IMMUTABLE_OBJECT.getEnumMapField(), mappedImmutable.getTestProtoMessageMap().get("key1").getEnumMapField());
    }

    @Test
    public void testDeepMappingImmutableToProto() {
        final TestProtos.DeepTestProtoMessage mappedProto = TestMapper.INSTANCE.mapDeepTestImmutableToProto(DEEP_TEST_IMMUTABLE_OBJECT);

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
