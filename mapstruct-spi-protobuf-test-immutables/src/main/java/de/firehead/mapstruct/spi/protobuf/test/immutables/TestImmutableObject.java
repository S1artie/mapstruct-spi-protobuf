/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.immutables;

import org.immutables.value.Value;

/**
 * Test immutable object for testing purposes.
 * This corresponds to the following test proto message:
 * <p>
 * message TestProtoMessage {
 * string stringField = 1;
 * int32 intField = 2;
 * int64 longField = 3;
 * float floatField = 4;
 * double doubleField = 5;
 * bool booleanField = 6;
 * bytes bytesField = 7;
 * TestEnum enumField = 8;
 * map<string, string> stringMapField = 9;
 * map<string, int32> intMapField = 10;
 * map<string, int64> longMapField = 11;
 * map<string, float> floatMapField = 12;
 * map<string, double> doubleMapField = 13;
 * map<string, bool> boolMapField = 14;
 * map<string, bytes> bytesMapField = 15;
 * map<string, TestEnum> enumMapField = 16;
 * }
 */
@Value.Immutable
public interface TestImmutableObject {

    String getStringField();

    int getIntField();

    long getLongField();

    float getFloatField();

    double getDoubleField();

    boolean getBooleanField();

    byte[] getBytesField();

    TestEnum getEnumField();

    java.util.Map<String, String> getStringMapField();

    java.util.Map<String, Integer> getIntMapField();

    java.util.Map<String, Long> getLongMapField();

    java.util.Map<String, Float> getFloatMapField();

    java.util.Map<String, Double> getDoubleMapField();

    java.util.Map<String, Boolean> getBoolMapField();

    java.util.Map<String, byte[]> getBytesMapField();

    java.util.Map<String, TestEnum> getEnumMapField();

}
