package com.learn.sub;

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
    public List<Integer> numberDecimalParser(int input){
        String s = String.valueOf(input);
        List<Integer> integerList = new ArrayList<>();
        for(int i= s.length(); i > 0;i--){
            int divisor = (int) Math.pow(10, i-1);
            int result = input/ divisor;
            input = input % divisor;
            integerList.add((int) (result*Math.pow(10, i-1)));
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

        List<Integer > integers = this.numberDecimalParser(num);

        for (Integer integer:
             integers) {
            System.out.println(integer);
        }
        return null;


    }


    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();

        integerToRoman.intToRoman(1094);
    }
}
