/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.records.mapper;

import com.google.protobuf.ByteString;
import de.firehead.mapstruct.spi.protobuf.test.protos.TestProtos;
import de.firehead.mapstruct.spi.protobuf.test.records.DeepTestRecord;
import de.firehead.mapstruct.spi.protobuf.test.records.TestRecord;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public abstract class TestMapper {

    public static final TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    public abstract TestRecord mapTestProtoToRecord(TestProtos.TestProtoMessage testProtoMessage);

    public abstract TestProtos.TestProtoMessage mapTestRecordToProto(TestRecord testRecord);

    public abstract DeepTestRecord mapDeepTestProtoToRecord(TestProtos.DeepTestProtoMessage deepTestProtoMessage);

    public abstract TestProtos.DeepTestProtoMessage mapDeepTestRecordToProto(DeepTestRecord testImmutableObject);

    protected byte[] mapByteStringToByteArray(com.google.protobuf.ByteString byteString) {
        return byteString.toByteArray();
    }

    protected ByteString mapByteArrayToByteString(byte[] byteArray) {
        return ByteString.copyFrom(byteArray);
    }
}
