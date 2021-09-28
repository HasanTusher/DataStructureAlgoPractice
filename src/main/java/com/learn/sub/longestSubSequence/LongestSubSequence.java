package com.learn.sub.longestSubSequence;

import java.util.Arrays;

public class LongestSubSequence {

    public int longestConsecutive(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            int start = i;

            for (int j = start; j < nums.length-1; j++) {
                if(nums[j+1] - nums[j] > 1)
                {
                    res = Math.max(res, (j-start)+1);
                    i=j;
                    break;
                };

                if(j == nums.length-2){
                    res = Math.max(res, (j-start)+1);
                    i=j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int nums[] = {100,4,200,1,3,2};
//        int nums[] = {0,3,7,2,5,8,4,6,0,1};
        int nums[] = {0,1};
        LongestSubSequence longestSubSequence = new LongestSubSequence();
        int x = longestSubSequence.longestConsecutive(nums);
        System.out.println(x);
    }
}
