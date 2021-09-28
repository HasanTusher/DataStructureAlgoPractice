package com.learn.sub.longestSubSequence;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestSubSequence {

    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        Arrays.sort(nums);
        int resArray[] = new int[nums.length];
        resArray[0] =1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == 1){
                resArray[i] = resArray[i-1]+1;
            }else if(nums[i] - nums[i-1] == 0){
                resArray[i] = resArray[i-1];
            } else
                resArray[i] = 1;
        }
        Arrays.sort(resArray);
        return resArray[resArray.length-1];
    }

    public static void main(String[] args) {
//        int nums[] = {100,4,200,1,3,2};
        int nums[] = {0,3,7,2,5,8,4,6,0,1};
//        int nums[] = {0,1};
        LongestSubSequence longestSubSequence = new LongestSubSequence();
        int x = longestSubSequence.longestConsecutive(nums);
        System.out.println(x);
    }
}
