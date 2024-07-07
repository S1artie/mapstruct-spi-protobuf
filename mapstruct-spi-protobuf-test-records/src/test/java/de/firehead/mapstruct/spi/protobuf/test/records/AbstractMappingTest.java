/* mapstruct-spi-protobuf-immutables
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.records;

import com.google.protobuf.ByteString;
import de.firehead.mapstruct.spi.protobuf.test.protos.TestProtos;

import java.util.Map;

public abstract class AbstractMappingTest {

    protected static final TestRecord TEST_RECORD = new TestRecord("test", 42, 42L, 42.0f, 42.0, true, new byte[]{0x01, 0x02, 0x03}, TestEnum.VALUE, Map.of("key1", "value1", "key2", "value2"), Map.of("key1", 42, "key2", 43), Map.of("key1", 42L, "key2", 43L), Map.of("key1", 42.0f, "key2", 42.1f), Map.of("key1", 42.0, "key2", 42.1), Map.of("key1", true, "key2", false), Map.of("key1", new byte[]{0x01, 0x02, 0x03}, "key2", new byte[]{0x04, 0x05, 0x06}), Map.of("key1", TestEnum.VALUE, "key2", TestEnum.VALUE));

    protected static final TestProtos.TestProtoMessage TEST_PROTO_MESSAGE = TestProtos.TestProtoMessage.newBuilder()
            .setStringField("test")
            .setIntField(42)
            .setLongField(42L)
            .setFloatField(42.0f)
            .setDoubleField(42.0)
            .setBooleanField(true)
            .setBytesField(ByteString.copyFrom(new byte[]{0x01, 0x02, 0x03}))
            .setEnumField(TestProtos.TestEnum.TEST_ENUM_VALUE)
            .putStringMapField("key1", "value1")
            .putStringMapField("key2", "value2")
            .putIntMapField("key1", 42)
            .putIntMapField("key2", 43)
            .putLongMapField("key1", 42L)
            .putLongMapField("key2", 43L)
            .putFloatMapField("key1", 42.0f)
            .putFloatMapField("key2", 42.1f)
            .putDoubleMapField("key1", 42.0)
            .putDoubleMapField("key2", 42.1)
            .putBoolMapField("key1", true)
            .putBoolMapField("key2", false)
            .putBytesMapField("key1", ByteString.copyFrom(new byte[]{0x01, 0x02, 0x03}))
            .putBytesMapField("key2", ByteString.copyFrom(new byte[]{0x04, 0x05, 0x06}))
            .putEnumMapField("key1", TestProtos.TestEnum.TEST_ENUM_VALUE)
            .putEnumMapField("key2", TestProtos.TestEnum.TEST_ENUM_VALUE)
            .build();

}
