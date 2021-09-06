package com.learn.sub.sumofthree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SumOfThreeHashSet {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length-1 ; i++) {
            HashSet<Integer> integers = new HashSet<>();

            for (int j = 0; j < nums.length; j++) {

                int temp = -(nums[i]+nums[j]);

                if(integers.contains(temp)){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(temp);
                    lists.add(res);

                }else {
                    integers.add(temp);
                }

            }

        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        SumOfThreeHashSet sumOfThree = new SumOfThreeHashSet();
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
