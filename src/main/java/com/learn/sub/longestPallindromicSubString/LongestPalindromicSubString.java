package com.learn.sub.longestPallindromicSubString;

public class LongestPalindromicSubString {

    private String isPalindrome(int start, int finish, String s){
        StringBuilder stringBuilder = new StringBuilder(s.substring(start, finish+1));
        if(stringBuilder.toString().equals(stringBuilder.reverse().toString()))
                return stringBuilder.toString();
        return null;
    }
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            int incStep = s.length() -i;
            for(int j = 0; j < s.length(); j++){
                int lastIndex = j+incStep;
                if(lastIndex > s.length()-1)
                    break;
                //System.out.println("first:" +j +", last: "+ lastIndex);
                String res = this.isPalindrome(j, lastIndex, s);
                if(res!=null)
                    return res;

            }
        }
        return String.valueOf(s.charAt(0));
    }

    public static void main(String[] args) {
//        String s = "babad";
//        String s = "cbbd";
        String s = "bb";

        LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();

        System.out.println(longestPalindromicSubString.longestPalindrome(s));
    }
}
