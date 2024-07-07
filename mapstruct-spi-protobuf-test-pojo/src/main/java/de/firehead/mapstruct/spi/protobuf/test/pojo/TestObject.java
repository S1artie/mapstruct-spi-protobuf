/* mapstruct-spi-protobuf
 *
 * Copyright (C) 2024
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package de.firehead.mapstruct.spi.protobuf.test.pojo;

import java.util.Map;

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
public class TestObject {

    private String stringField;

    private int intField;

    private long longField;

    private float floatField;

    private double doubleField;

    private boolean booleanField;

    private byte[] bytesField;

    private TestEnum enumField;

    private java.util.Map<String, String> stringMapField;

    private java.util.Map<String, Integer> intMapField;

    private java.util.Map<String, Long> longMapField;

    private java.util.Map<String, Float> floatMapField;

    private java.util.Map<String, Double> doubleMapField;

    private java.util.Map<String, Boolean> boolMapField;

    private java.util.Map<String, byte[]> bytesMapField;

    private java.util.Map<String, TestEnum> enumMapField;

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public int getIntField() {
        return intField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    public long getLongField() {
        return longField;
    }

    public void setLongField(long longField) {
        this.longField = longField;
    }

    public float getFloatField() {
        return floatField;
    }

    public void setFloatField(float floatField) {
        this.floatField = floatField;
    }

    public double getDoubleField() {
        return doubleField;
    }

    public void setDoubleField(double doubleField) {
        this.doubleField = doubleField;
    }

    public boolean getBooleanField() {
        return booleanField;
    }

    public void setBooleanField(boolean booleanField) {
        this.booleanField = booleanField;
    }

    public byte[] getBytesField() {
        return bytesField;
    }

    public void setBytesField(byte[] bytesField) {
        this.bytesField = bytesField;
    }

    public TestEnum getEnumField() {
        return enumField;
    }

    public void setEnumField(TestEnum enumField) {
        this.enumField = enumField;
    }

    public Map<String, String> getStringMapField() {
        return stringMapField;
    }

    public void setStringMapField(Map<String, String> stringMapField) {
        this.stringMapField = stringMapField;
    }

    public Map<String, Integer> getIntMapField() {
        return intMapField;
    }

    public void setIntMapField(Map<String, Integer> intMapField) {
        this.intMapField = intMapField;
    }

    public Map<String, Long> getLongMapField() {
        return longMapField;
    }

    public void setLongMapField(Map<String, Long> longMapField) {
        this.longMapField = longMapField;
    }

    public Map<String, Float> getFloatMapField() {
        return floatMapField;
    }

    public void setFloatMapField(Map<String, Float> floatMapField) {
        this.floatMapField = floatMapField;
    }

    public Map<String, Double> getDoubleMapField() {
        return doubleMapField;
    }

    public void setDoubleMapField(Map<String, Double> doubleMapField) {
        this.doubleMapField = doubleMapField;
    }

    public Map<String, Boolean> getBoolMapField() {
        return boolMapField;
    }

    public void setBoolMapField(Map<String, Boolean> boolMapField) {
        this.boolMapField = boolMapField;
    }

    public Map<String, byte[]> getBytesMapField() {
        return bytesMapField;
    }

    public void setBytesMapField(Map<String, byte[]> bytesMapField) {
        this.bytesMapField = bytesMapField;
    }

    public Map<String, TestEnum> getEnumMapField() {
        return enumMapField;
    }

    public void setEnumMapField(Map<String, TestEnum> enumMapField) {
        this.enumMapField = enumMapField;
    }
}
