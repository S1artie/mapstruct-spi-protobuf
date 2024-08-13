/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.proto2proto.mapper;

import com.google.protobuf.ByteString;
import de.firehead.mapstruct.spi.protobuf.test.proto2proto.Proto2ProtoTestProtos;
import de.firehead.mapstruct.spi.protobuf.test.protos.TestProtos;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public abstract class TestMapper {

    public static final TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    public abstract Proto2ProtoTestProtos.OtherTestProtoMessage mapTestProtoToOtherProto(TestProtos.TestProtoMessage testProtoMessage);

    public abstract TestProtos.TestProtoMessage mapOtherProtoToProto(Proto2ProtoTestProtos.OtherTestProtoMessage testObject);

    public abstract Proto2ProtoTestProtos.OtherDeepTestProtoMessage mapDeepTestProtoToOtherProto(TestProtos.DeepTestProtoMessage deepTestProtoMessage);

    public abstract TestProtos.DeepTestProtoMessage mapDeepTestOtherProtoToProto(Proto2ProtoTestProtos.OtherDeepTestProtoMessage testImmutableObject);

    public abstract TestProtos.TestEnum mapOtherEnumToEnum(Proto2ProtoTestProtos.OtherTestEnum otherTestEnum);

    public abstract Proto2ProtoTestProtos.OtherTestEnum mapEnumToOtherEnum(TestProtos.TestEnum testEnum);

    protected byte[] mapByteStringToByteArray(com.google.protobuf.ByteString byteString) {
        return byteString.toByteArray();
    }

    protected ByteString mapByteArrayToByteString(byte[] byteArray) {
        return ByteString.copyFrom(byteArray);
    }
}
