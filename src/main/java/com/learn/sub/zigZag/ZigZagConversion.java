package com.learn.sub.zigZag;

public class ZigZagConversion {

    public String convert(String s, int numRows) {


        for (int i = 0; i < numRows; i++) {
           int stepSize = numRows+2;

           for (int j = 0; j < numRows; j++) {
               int index = j*stepSize;
               if(index > s.length())
                   break;
               char  c = s.charAt(index);
               System.out.println(c);

           }
           if(i==0)
               break;
        }

        return null;

    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();

        zigZagConversion.convert("PAYPALISHIRING", 4);
    }
}
