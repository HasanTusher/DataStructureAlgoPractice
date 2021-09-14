package com.learn.sub.integerToRoman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntegerToRoman {


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

    /**
     * Number to Decimal Place parser
     *
     * @param input
     * @return ArrayList
     */
    public List<DecimalResult> numberDecimalParser(int input){
        String s = String.valueOf(input);
        List<DecimalResult> integerList = new ArrayList<>();
        for(int i= s.length(); i > 0;i--){
            int divisor = (int) Math.pow(10, i-1);
            int result = input/ divisor;
            int actualResult = result*divisor;
            input = input % divisor;
            DecimalResult decimalResult = new DecimalResult(result, divisor, actualResult);
            integerList.add(decimalResult);
        }
        return integerList;
    }


    public String intToRoman(int num) {
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(1, "I");
        integerStringHashMap.put(2, "II");
        integerStringHashMap.put(3, "III");
        integerStringHashMap.put(4, "IV");
        integerStringHashMap.put(5, "V");
        integerStringHashMap.put(6, "VI");
        integerStringHashMap.put(7, "VII");
        integerStringHashMap.put(8, "VIII");
        integerStringHashMap.put(9, "IX");
        integerStringHashMap.put(10, "X");


        integerStringHashMap.put(50, "L");
        integerStringHashMap.put(100, "C");
        integerStringHashMap.put(500, "D");
        integerStringHashMap.put(1000, "M");
        integerStringHashMap.put(90, "XC");
        integerStringHashMap.put(40, "XL");
        integerStringHashMap.put(400, "CD");
        integerStringHashMap.put(900, "CM");
        List<DecimalResult> integers = this.numberDecimalParser(num);



        StringBuilder stringBuilder = new StringBuilder();
        for (DecimalResult integer:
             integers) {
            stringBuilder.append(this.processDecimalResult(integer, integerStringHashMap));
        }

        return stringBuilder.toString();


    }

    private String processDecimalResult(DecimalResult decimalResult, HashMap<Integer, String> integerStringHashMap) {
        //int actualResult = decimalResult.count * decimalResult.getDecimalValue();
        String romanBase;
        if(integerStringHashMap.get(decimalResult.getActualValue()) != null){
            romanBase  = integerStringHashMap.get(decimalResult.getActualValue());
            return romanBase;
        }
        else
            romanBase = integerStringHashMap.get(decimalResult.getDecimalValue());

        StringBuilder stringBuilder = new StringBuilder();

        if(decimalResult.getActualValue() > 50 && decimalResult.getActualValue() < 90){
            romanBase = integerStringHashMap.get(50);
            stringBuilder.append(romanBase);
            int rest = decimalResult.getActualValue() - 50;
            //System.out.println(rest);
            stringBuilder.append(this.intToRoman(rest));
            return stringBuilder.toString();
        }

        for(int i=0; i< decimalResult.getCount(); i++){
            stringBuilder.append(romanBase);
        }

        //System.out.println(decimalResult.toString());
        //System.out.println(stringBuilder.toString());
        return stringBuilder.toString();


    }


    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(88));
    }
}
