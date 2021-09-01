package com.learn.sub;

import com.sun.media.sound.SF2InstrumentRegion;

public class ShortestSubTwoPointer {

    public int shortestSubarray(int[] arr, int k) {
        int start =0;
        int end = 0;
        int currentSum = 0;
        int result= k+1;


        while (end < arr.length){
            currentSum+=arr[end]; //increment
            if(currentSum >= k){
                result = Math.min((end-start)+1, result);
            }

            while (currentSum >= k){
                currentSum-=arr[start];
                start++;
                if(currentSum >=k){
                    result--;
                }
            }

            end++;

        }

        return result == k+1 ? -1 : result;


    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        ShortestSubTwoPointer shortestSubTwoPointer = new ShortestSubTwoPointer();

        int result = shortestSubTwoPointer.shortestSubarray(arr, 5);
        System.out.println(result);
    }
}
