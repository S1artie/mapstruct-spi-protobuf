/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.records;

import java.util.Map;

/**
 * Test immutable record for testing purposes.
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
 * TestEnumWithoutPrefixes enumWithoutPrefixesField = 9;
 * map<string, string> stringMapField = 10;
 * map<string, int32> intMapField = 11;
 * map<string, int64> longMapField = 12;
 * map<string, float> floatMapField = 13;
 * map<string, double> doubleMapField = 14;
 * map<string, bool> boolMapField = 15;
 * map<string, bytes> bytesMapField = 16;
 * map<string, TestEnum> enumMapField = 17;
 * }
 */
public record TestRecord(String stringField, int intField, long longField, float floatField, double doubleField,
                         boolean booleanField, byte[] bytesField, TestEnum enumField,
                         TestEnumWithoutPrefixes enumWithoutPrefixesField,
                         Map<String, String> stringMapField,
                         Map<String, Integer> intMapField, Map<String, Long> longMapField,
                         Map<String, Float> floatMapField,
                         Map<String, Double> doubleMapField, Map<String, Boolean> boolMapField,
                         Map<String, byte[]> bytesMapField,
                         Map<String, TestEnum> enumMapField) {
}
