package com.learn.sub.integerToRoman;

public class DecimalResult {
    int decimalValue;
    int count = 0;
    int actualValue;

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DecimalResult(int count, int decimalValue, int actualValue) {
        this.decimalValue = decimalValue;
        this.count = count;
        this.actualValue = actualValue;
    }

    public DecimalResult(int count, int decimalValue) {
        this.decimalValue = decimalValue;
        this.count = count;
    }

    public int getDecimalValue() {
        return decimalValue;
    }

    public void setDecimalValue(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    @Override
    public String toString() {
        return "DecimalResult{" +
                "decimalValue=" + decimalValue +
                ", count=" + count +
                ", actualValue=" + actualValue +
                '}';
    }
}
