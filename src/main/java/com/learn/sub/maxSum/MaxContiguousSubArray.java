package com.learn.sub.maxSum;

public class MaxContiguousSubArray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tempMax = 0;
            for (int j = i; j < nums.length; j++) {
                tempMax+=nums[j];
                max = Math.max(tempMax, max);
            }
        }

        return max;
    }
    public static void main(String[] args) {
//        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        int nums[] = {1};
        MaxContiguousSubArray maxContiguousSubArray = new MaxContiguousSubArray();
        System.out.println(maxContiguousSubArray.maxSubArray(nums));

    }
}
