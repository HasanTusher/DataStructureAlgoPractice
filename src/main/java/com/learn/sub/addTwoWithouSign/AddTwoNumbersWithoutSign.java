package com.learn.sub.addTwoWithouSign;

import java.math.BigInteger;

public class AddTwoNumbersWithoutSign {

    public int getSum(int a, int b) {
       int res, carry;

       while (b!=0){
           res = a^b;
           carry = (a&b)<<1;

           a = res;
           b= carry;

       }

       return a;
    }

    public static void main(String[] args) {
        AddTwoNumbersWithoutSign addTwoNumbersWithoutSign =new AddTwoNumbersWithoutSign();
        addTwoNumbersWithoutSign.getSum(2, 3);
    }
}
