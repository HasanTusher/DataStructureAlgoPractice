package com.learn.sub.twoSum;

import java.util.Arrays;
import java.util.HashMap;
//write a function to find largest of two numbers
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerListHashMap = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i< nums.length; i++){
            int complement = target-nums[i];
            if(integerListHashMap.get(complement) != null){
                result[0] = integerListHashMap.get(complement);
                result[1] = i;
                return result;
            }
            else{
                integerListHashMap.put(nums[i], i);
            }


        }
        return result;

    }

    public static void main(String[] args) {
       int nums[] = {2,7,11,15, 10, 18, 99};
       int target = 109;
       TwoSum twoSum = new TwoSum();
       int[] arr = twoSum.twoSum(nums, target);
       System.out.println(Arrays.toString(arr));
    }
}
