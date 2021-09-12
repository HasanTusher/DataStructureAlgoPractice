package com.learn.sub.zigZag;

public class ZigZagConversion {

    public String convert(String s, int numRows) {


        for (int i = 0; i < numRows; i++) {

           int ziggedRow = numRows-i; //before last

           for (int j = 0; j <numRows; j+=ziggedRow) {
               //int index = ziggedRow - j;
              // System.out.println(ziggedRow);
               System.out.println(s.charAt(ziggedRow));

           }
        }

        return null;

    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();

        zigZagConversion.convert("PAYPALISHIRING", 3);
    }
}
