package com.learn.sub.integerToRoman;

public class DecimalResult {
    int decimalValue;
    int count = 0;

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
                '}';
    }
}
