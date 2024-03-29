package com.learn.sub.longestPallindromicSubString;

import java.util.Arrays;

public class LongestPalindromicDynamic {
    static void printSubStr(
            String str, int low, int high)
    {
        System.out.println(
                str.substring(
                        low, high + 1));
    }

    // This function prints the longest
    // palindrome substring of str[].
    // It also returns the length of the
    // longest palindrome
    static int longestPalSubstr(String str)
    {
        // get length of input string
        int n = str.length();

        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;
//        for(boolean[] x: table)
//            System.out.println(Arrays.toString(x));

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2.
        // k is length of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] &&
                        str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start,
                start + maxLength - 1);

        // return length of LPS
        return maxLength;
    }

    static void print2dArray(int[][] arr){
        for(int[] x: arr)
            System.out.println(Arrays.toString(x));
    }

    static String longestPalSubstr2(String str)
    {
        int start = 0;
        int length=0;
        int size = str.length();

        int[][] arr = new int[size][size];

        if(str.length() ==1)
            return str;

        for(int i=0;i< size; i++)
            arr[i][i] = 1;
        //print2dArray(arr);

        for(int i=0; i< size-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                arr[i][i+1] = 1;
                length = 2;
                start = i;
            }
        }

        for (int k=3; k <= size; k++){
            System.out.println("for k: "+k);
            for(int j=0; j< size-k+1; j++){

                int last = j+k-1;
                if(str.charAt(j) == str.charAt(last) &&
                    arr[j+1][last-1] == 1)
                { //found the palindrome
                    arr[j][last] = 1;

                    if(k > length){
                        length  = k;
                        start = j;
                    }

                }

                //System.out.println("from: "+j+"; to: "+last);
            }

        }


        //System.out.println(str.substring(start, start+length));
        if(length == 0){
            return String.valueOf(str.charAt(0));
        }

        return str.substring(start, start+length);
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {

//        String str = "ebabc";
//        String str = "forgeeksskeegfor";
        String str = "cb";

        System.out.println("Length is: " + longestPalSubstr2(str));
    }
}
