/* mapstruct-spi-protobuf-immutables
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.records;

import java.util.List;
import java.util.Map;

/**
 * Test immutable object for deep testing purposes.
 * This corresponds to the following test proto message:
 * <p>
 * message DeepTestProtoMessage {
 * TestProtoMessage testProtoMessage = 1;
 * repeated TestProtoMessage testProtoMessageList = 2;
 * map<string, TestProtoMessage> testProtoMessageMap = 3;
 * }
 */
public record DeepTestRecord(TestRecord testProtoMessagePlain,
                             List<TestRecord> testProtoMessageList,
                             Map<String, TestRecord> testProtoMessageMap) {
}
