package com.learn.sub.sumofthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++){
            for (int j= i+1; j<nums.length-1; j++){
                for(int k=j+1; k< nums.length; k++){
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
        int[] nums = {-1,0,1,2,-1,-4};
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
