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

public class SimpleMappingTest extends AbstractMappingTest {

    @Test
    public void testSimpleMappingProtoToPojo() {
        final TestRecord mappedRecord = TestMapper.INSTANCE.mapTestProtoToRecord(TEST_PROTO_MESSAGE);

        Assertions.assertEquals(TEST_RECORD.stringField(), mappedRecord.stringField());
        Assertions.assertEquals(TEST_RECORD.intField(), mappedRecord.intField());
        Assertions.assertEquals(TEST_RECORD.longField(), mappedRecord.longField());
        Assertions.assertEquals(TEST_RECORD.floatField(), mappedRecord.floatField());
        Assertions.assertEquals(TEST_RECORD.doubleField(), mappedRecord.doubleField());
        Assertions.assertEquals(TEST_RECORD.booleanField(), mappedRecord.booleanField());
        Assertions.assertArrayEquals(TEST_RECORD.bytesField(), mappedRecord.bytesField());
        Assertions.assertEquals(TEST_RECORD.enumField(), mappedRecord.enumField());
        Assertions.assertEquals(TEST_RECORD.stringMapField(), mappedRecord.stringMapField());
        Assertions.assertEquals(TEST_RECORD.intMapField(), mappedRecord.intMapField());
        Assertions.assertEquals(TEST_RECORD.longMapField(), mappedRecord.longMapField());
        Assertions.assertEquals(TEST_RECORD.floatMapField(), mappedRecord.floatMapField());
        Assertions.assertEquals(TEST_RECORD.doubleMapField(), mappedRecord.doubleMapField());
        Assertions.assertEquals(TEST_RECORD.boolMapField(), mappedRecord.boolMapField());
        Assertions.assertEquals(TEST_RECORD.bytesMapField().size(), mappedRecord.bytesMapField().size());
        for (final String key : TEST_RECORD.bytesMapField().keySet()) {
            Assertions.assertArrayEquals(TEST_RECORD.bytesMapField().get(key), mappedRecord.bytesMapField().get(key));
        }
        Assertions.assertEquals(TEST_RECORD.enumMapField(), mappedRecord.enumMapField());
    }

    @Test
    public void testSimpleMappingPojoToProto() {
        final TestProtos.TestProtoMessage mappedProto = TestMapper.INSTANCE.mapTestRecordToProto(TEST_RECORD);

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
