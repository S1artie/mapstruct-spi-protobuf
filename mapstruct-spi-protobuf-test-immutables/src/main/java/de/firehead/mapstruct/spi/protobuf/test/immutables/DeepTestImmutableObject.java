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
 * Test immutable object for deep testing purposes.
 * This corresponds to the following test proto message:
 * <p>
 * message DeepTestProtoMessage {
 * TestProtoMessage testProtoMessage = 1;
 * repeated TestProtoMessage testProtoMessageList = 2;
 * map<string, TestProtoMessage> testProtoMessageMap = 3;
 * }
 */
@Value.Immutable
public interface DeepTestImmutableObject {

    TestImmutableObject getTestProtoMessagePlain();

    java.util.List<TestImmutableObject> getTestProtoMessageList();

    java.util.Map<String, TestImmutableObject> getTestProtoMessageMap();

}
