/* mapstruct-spi-protobuf-immutables
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.pojo;

import com.google.protobuf.ByteString;
import de.firehead.mapstruct.spi.protobuf.test.protos.TestProtos;

import java.util.HashMap;

public abstract class AbstractMappingTest {

    protected static final TestObject TEST_OBJECT = new TestObject();

    static {
        TEST_OBJECT.setStringField("test");
        TEST_OBJECT.setIntField(42);
        TEST_OBJECT.setLongField(42L);
        TEST_OBJECT.setFloatField(42.0f);
        TEST_OBJECT.setDoubleField(42.0);
        TEST_OBJECT.setBooleanField(true);
        TEST_OBJECT.setBytesField(new byte[]{0x01, 0x02, 0x03});
        TEST_OBJECT.setEnumField(TestEnum.VALUE);
        TEST_OBJECT.setStringMapField(new HashMap<>());
        TEST_OBJECT.getStringMapField().put("key1", "value1");
        TEST_OBJECT.getStringMapField().put("key2", "value2");
        TEST_OBJECT.setIntMapField(new HashMap<>());
        TEST_OBJECT.getIntMapField().put("key1", 42);
        TEST_OBJECT.getIntMapField().put("key2", 43);
        TEST_OBJECT.setLongMapField(new HashMap<>());
        TEST_OBJECT.getLongMapField().put("key1", 42L);
        TEST_OBJECT.getLongMapField().put("key2", 43L);
        TEST_OBJECT.setFloatMapField(new HashMap<>());
        TEST_OBJECT.getFloatMapField().put("key1", 42.0f);
        TEST_OBJECT.getFloatMapField().put("key2", 42.1f);
        TEST_OBJECT.setDoubleMapField(new HashMap<>());
        TEST_OBJECT.getDoubleMapField().put("key1", 42.0);
        TEST_OBJECT.getDoubleMapField().put("key2", 42.1);
        TEST_OBJECT.setBoolMapField(new HashMap<>());
        TEST_OBJECT.getBoolMapField().put("key1", true);
        TEST_OBJECT.getBoolMapField().put("key2", false);
        TEST_OBJECT.setBytesMapField(new HashMap<>());
        TEST_OBJECT.getBytesMapField().put("key1", new byte[]{0x01, 0x02, 0x03});
        TEST_OBJECT.getBytesMapField().put("key2", new byte[]{0x04, 0x05, 0x06});
        TEST_OBJECT.setEnumMapField(new HashMap<>());
        TEST_OBJECT.getEnumMapField().put("key1", TestEnum.VALUE);
        TEST_OBJECT.getEnumMapField().put("key2", TestEnum.VALUE);
    }

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
