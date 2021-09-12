package com.learn.sub.palindrome;

public class Palindrome {

    public boolean isPalindrome(int x){

        String a =  String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(a);
        return a.equals(stringBuilder.reverse().toString());
    }
    public static void main(String[] args) {

    }
}
