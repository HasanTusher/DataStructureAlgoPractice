package com.learn.sub.integerToRoman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntegerToRoman {
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
        String input = String.valueOf(num);
        String roman[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(1, "I");
        integerStringHashMap.put(5, "V");
        integerStringHashMap.put(10, "X");
        integerStringHashMap.put(50, "L");
        integerStringHashMap.put(100, "C");
        integerStringHashMap.put(500, "D");
        integerStringHashMap.put(1000, "M");
        List<DecimalResult> integers = this.numberDecimalParser(num);

        StringBuilder stringBuilder = new StringBuilder();
        for (DecimalResult integer:
             integers) {
            this.processDecimalResult(integer, integerStringHashMap);
        }

        return null;


    }

    private String processDecimalResult(DecimalResult decimalResult, HashMap<Integer, String> integerStringHashMap) {
        int actualResult = decimalResult.count * decimalResult.getDecimalValue();
        String romanBase;
        if(integerStringHashMap.get(actualResult) != null)
             romanBase  = integerStringHashMap.get(actualResult);
        else
            romanBase = integerStringHashMap.get(decimalResult.getDecimalValue());

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< decimalResult.getCount(); i++){
            stringBuilder.append(romanBase);
        }

        System.out.println(decimalResult.toString());
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();


    }


    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        integerToRoman.intToRoman(1040);
    }
}
