/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.records;

import de.firehead.mapstruct.spi.protobuf.test.protos.TestProtos;
import de.firehead.mapstruct.spi.protobuf.test.records.mapper.TestMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class DeepMappingTest extends AbstractMappingTest {

    private static final DeepTestRecord DEEP_TEST_RECORD = new DeepTestRecord(TEST_RECORD, Collections.singletonList(TEST_RECORD), Collections.singletonMap("key1", TEST_RECORD));

    private static final TestProtos.DeepTestProtoMessage DEEP_TEST_PROTO_MESSAGE = TestProtos.DeepTestProtoMessage.newBuilder()
            .setTestProtoMessagePlain(TEST_PROTO_MESSAGE)
            .addTestProtoMessageList(TEST_PROTO_MESSAGE)
            .putTestProtoMessageMap("key1", TEST_PROTO_MESSAGE)
            .build();


    @Test
    public void testDeepMappingProtoToRecord() {
        final DeepTestRecord mappedRecord = TestMapper.INSTANCE.mapDeepTestProtoToRecord(DEEP_TEST_PROTO_MESSAGE);

        // Test testProtoMessage
        Assertions.assertEquals(TEST_RECORD.stringField(), mappedRecord.testProtoMessagePlain().stringField());
        Assertions.assertEquals(TEST_RECORD.intField(), mappedRecord.testProtoMessagePlain().intField());
        Assertions.assertEquals(TEST_RECORD.longField(), mappedRecord.testProtoMessagePlain().longField());
        Assertions.assertEquals(TEST_RECORD.floatField(), mappedRecord.testProtoMessagePlain().floatField());
        Assertions.assertEquals(TEST_RECORD.doubleField(), mappedRecord.testProtoMessagePlain().doubleField());
        Assertions.assertEquals(TEST_RECORD.booleanField(), mappedRecord.testProtoMessagePlain().booleanField());
        Assertions.assertArrayEquals(TEST_RECORD.bytesField(), mappedRecord.testProtoMessagePlain().bytesField());
        Assertions.assertEquals(TEST_RECORD.enumField(), mappedRecord.testProtoMessagePlain().enumField());
        Assertions.assertEquals(TEST_RECORD.stringMapField(), mappedRecord.testProtoMessagePlain().stringMapField());
        Assertions.assertEquals(TEST_RECORD.intMapField(), mappedRecord.testProtoMessagePlain().intMapField());
        Assertions.assertEquals(TEST_RECORD.longMapField(), mappedRecord.testProtoMessagePlain().longMapField());
        Assertions.assertEquals(TEST_RECORD.floatMapField(), mappedRecord.testProtoMessagePlain().floatMapField());
        Assertions.assertEquals(TEST_RECORD.doubleMapField(), mappedRecord.testProtoMessagePlain().doubleMapField());
        Assertions.assertEquals(TEST_RECORD.boolMapField(), mappedRecord.testProtoMessagePlain().boolMapField());
        Assertions.assertEquals(TEST_RECORD.bytesMapField().size(), mappedRecord.testProtoMessagePlain().bytesMapField().size());
        for (final String key : TEST_RECORD.bytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_RECORD.bytesMapField().get(key), mappedRecord.testProtoMessagePlain().bytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_RECORD.enumMapField(), mappedRecord.testProtoMessagePlain().enumMapField());

        // Test testProtoMessageList
        Assertions.assertEquals(1, mappedRecord.testProtoMessageList().size());
        Assertions.assertEquals(TEST_RECORD.stringField(), mappedRecord.testProtoMessageList().get(0).stringField());
        Assertions.assertEquals(TEST_RECORD.intField(), mappedRecord.testProtoMessageList().get(0).intField());
        Assertions.assertEquals(TEST_RECORD.longField(), mappedRecord.testProtoMessageList().get(0).longField());
        Assertions.assertEquals(TEST_RECORD.floatField(), mappedRecord.testProtoMessageList().get(0).floatField());
        Assertions.assertEquals(TEST_RECORD.doubleField(), mappedRecord.testProtoMessageList().get(0).doubleField());
        Assertions.assertEquals(TEST_RECORD.booleanField(), mappedRecord.testProtoMessageList().get(0).booleanField());
        Assertions.assertArrayEquals(TEST_RECORD.bytesField(), mappedRecord.testProtoMessageList().get(0).bytesField());
        Assertions.assertEquals(TEST_RECORD.enumField(), mappedRecord.testProtoMessageList().get(0).enumField());
        Assertions.assertEquals(TEST_RECORD.stringMapField(), mappedRecord.testProtoMessageList().get(0).stringMapField());
        Assertions.assertEquals(TEST_RECORD.intMapField(), mappedRecord.testProtoMessageList().get(0).intMapField());
        Assertions.assertEquals(TEST_RECORD.longMapField(), mappedRecord.testProtoMessageList().get(0).longMapField());
        Assertions.assertEquals(TEST_RECORD.floatMapField(), mappedRecord.testProtoMessageList().get(0).floatMapField());
        Assertions.assertEquals(TEST_RECORD.doubleMapField(), mappedRecord.testProtoMessageList().get(0).doubleMapField());
        Assertions.assertEquals(TEST_RECORD.boolMapField(), mappedRecord.testProtoMessageList().get(0).boolMapField());
        Assertions.assertEquals(TEST_RECORD.bytesMapField().size(), mappedRecord.testProtoMessageList().get(0).bytesMapField().size());
        for (final String key : TEST_RECORD.bytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_RECORD.bytesMapField().get(key), mappedRecord.testProtoMessageList().get(0).bytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_RECORD.enumMapField(), mappedRecord.testProtoMessageList().get(0).enumMapField());

        // Test testProtoMessageMap
        Assertions.assertEquals(1, mappedRecord.testProtoMessageMap().size());
        Assertions.assertEquals(TEST_RECORD.stringField(), mappedRecord.testProtoMessageMap().get("key1").stringField());
        Assertions.assertEquals(TEST_RECORD.intField(), mappedRecord.testProtoMessageMap().get("key1").intField());
        Assertions.assertEquals(TEST_RECORD.longField(), mappedRecord.testProtoMessageMap().get("key1").longField());
        Assertions.assertEquals(TEST_RECORD.floatField(), mappedRecord.testProtoMessageMap().get("key1").floatField());
        Assertions.assertEquals(TEST_RECORD.doubleField(), mappedRecord.testProtoMessageMap().get("key1").doubleField());
        Assertions.assertEquals(TEST_RECORD.booleanField(), mappedRecord.testProtoMessageMap().get("key1").booleanField());
        Assertions.assertArrayEquals(TEST_RECORD.bytesField(), mappedRecord.testProtoMessageMap().get("key1").bytesField());
        Assertions.assertEquals(TEST_RECORD.enumField(), mappedRecord.testProtoMessageMap().get("key1").enumField());
        Assertions.assertEquals(TEST_RECORD.stringMapField(), mappedRecord.testProtoMessageMap().get("key1").stringMapField());
        Assertions.assertEquals(TEST_RECORD.intMapField(), mappedRecord.testProtoMessageMap().get("key1").intMapField());
        Assertions.assertEquals(TEST_RECORD.longMapField(), mappedRecord.testProtoMessageMap().get("key1").longMapField());
        Assertions.assertEquals(TEST_RECORD.floatMapField(), mappedRecord.testProtoMessageMap().get("key1").floatMapField());
        Assertions.assertEquals(TEST_RECORD.doubleMapField(), mappedRecord.testProtoMessageMap().get("key1").doubleMapField());
        Assertions.assertEquals(TEST_RECORD.boolMapField(), mappedRecord.testProtoMessageMap().get("key1").boolMapField());
        Assertions.assertEquals(TEST_RECORD.bytesMapField().size(), mappedRecord.testProtoMessageMap().get("key1").bytesMapField().size());
        for (final String key : TEST_RECORD.bytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_RECORD.bytesMapField().get(key), mappedRecord.testProtoMessageMap().get("key1").bytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_RECORD.enumMapField(), mappedRecord.testProtoMessageMap().get("key1").enumMapField());
    }

    @Test
    public void testDeepMappingRecordToProto() {
        final TestProtos.DeepTestProtoMessage mappedProto = TestMapper.INSTANCE.mapDeepTestRecordToProto(DEEP_TEST_RECORD);

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
