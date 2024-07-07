/* mapstruct-spi-protobuf-immutables
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
public record TestRecord(String stringField, int intField, long longField, float floatField, double doubleField,
                         boolean booleanField, byte[] bytesField, TestEnum enumField,
                         Map<String, String> stringMapField,
                         Map<String, Integer> intMapField, Map<String, Long> longMapField,
                         Map<String, Float> floatMapField,
                         Map<String, Double> doubleMapField, Map<String, Boolean> boolMapField,
                         Map<String, byte[]> bytesMapField,
                         Map<String, TestEnum> enumMapField) {
}
