/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.pojo;

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
public class DeepTestObject {

    TestObject testProtoMessagePlain;

    java.util.List<TestObject> testProtoMessageList;

    java.util.Map<String, TestObject> testProtoMessageMap;

    public TestObject getTestProtoMessagePlain() {
        return testProtoMessagePlain;
    }

    public void setTestProtoMessagePlain(TestObject testProtoMessagePlain) {
        this.testProtoMessagePlain = testProtoMessagePlain;
    }

    public List<TestObject> getTestProtoMessageList() {
        return testProtoMessageList;
    }

    public void setTestProtoMessageList(List<TestObject> testProtoMessageList) {
        this.testProtoMessageList = testProtoMessageList;
    }

    public Map<String, TestObject> getTestProtoMessageMap() {
        return testProtoMessageMap;
    }

    public void setTestProtoMessageMap(Map<String, TestObject> testProtoMessageMap) {
        this.testProtoMessageMap = testProtoMessageMap;
    }
}
