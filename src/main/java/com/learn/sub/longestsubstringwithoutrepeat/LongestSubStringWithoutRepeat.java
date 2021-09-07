package com.learn.sub.longestsubstringwithoutrepeat;

public class LongestSubStringWithoutRepeat {

    public int lengthOfLongestSubstring(String str) {

        String sub = "";
        int length = -1;

        if(str.isEmpty())
            return 0;
        for (char c : str.toCharArray()){
            String cur = String.valueOf(c);
            if(sub.contains(cur)){
                sub = sub.substring(sub.indexOf(cur)+1);

            }
            sub = sub + String.valueOf(c); //add the sub to current result
            length = Math.max(sub.length(), length);
        }

        return length;

//        String test = "";
//
//        // Result
//        int maxLength = -1;
//
//        // Return zero if string is empty
//        if (str.isEmpty()) {
//            return 0;
//        }
//        // Return one if string length is one
//        else if (str.length() == 1) {
//            return 1;
//        }
//        for (char c : str.toCharArray()) {
//            String current = String.valueOf(c);
//
//            // If string already contains the character
//            // Then substring after repeating character
//            if (test.contains(current)) {
//                test = test.substring(test.indexOf(current)+ 1);
//            }
//            test = test + String.valueOf(c);
//            maxLength = Math.max(test.length(), maxLength);
//        }
//
//        return maxLength;


    }

    public static void main(String[] args) {
        String aa = "aaabcdefff";

        LongestSubStringWithoutRepeat longestSubStringWithoutRepeat = new LongestSubStringWithoutRepeat();
        int a = longestSubStringWithoutRepeat.lengthOfLongestSubstring(aa);

        System.out.println(a);
    }

}
