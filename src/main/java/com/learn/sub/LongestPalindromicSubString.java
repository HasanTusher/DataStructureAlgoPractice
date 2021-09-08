package com.learn.sub;

public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {
        StringBuilder stringBuilder;
        for(int i = s.length()-1; i > 0; i-- ){
            stringBuilder = new StringBuilder(s.substring(0, i));
            if(stringBuilder.toString().equals(stringBuilder.reverse().toString()))
                return stringBuilder.toString();
        }

        return String.valueOf(s.charAt(0));
    }

    public static void main(String[] args) {
//        String s = "babad";
        String s = "cbbd";

        LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();

        System.out.println(longestPalindromicSubString.longestPalindrome(s));
    }
}
