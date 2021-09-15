package com.learn.sub.sumOfThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j= i+1; j<nums.length-1; j++){
                if(j > (i+1) && nums[j] == nums[j-1])
                    continue;
                for(int k=j+1; k< nums.length; k++){
                    if( k > (j+1) && nums[k] == nums[k-1])
                        continue;
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        lists.add(integers);
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0,0};
        SumOfThree sumOfThree = new SumOfThree();
        List<List<Integer>> lists = sumOfThree.threeSum(nums);
        for (int i = 0; i < lists.size(); i++){

            for (int j = 0; j < lists.get(i).size(); j++){
                System.out.print(lists.get(i).get(j));
                System.out.print(" ");

            }
            System.out.println("\n");
        }


    }
}
