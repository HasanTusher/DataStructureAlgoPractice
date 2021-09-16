package com.learn.sub.sumOfThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                int low = i+1;
                int high = nums.length-1;
                int sum = 0-nums[i];
                while (low < high){
                    if(nums[low]+nums[high] == sum)
                    {
                        //System.out.println(nums[i]+"; "+nums[low]+"; "+ nums[high]);
                        lists.add(Arrays.asList(nums[i], nums[low], nums[high])); //found a pair

                        while (low < high && nums[low] == nums[low+1]){
                            //System.out.println("here:"+nums[low]+"; "+nums[low+1]);
                            low++;

                        }
                        while (low < high && nums[high] == nums[high-1]){
                            System.out.println("there:"+nums[low]+"; "+nums[low+1]);
                            high--;

                        }
                        low++;
                        high--;

                    }else if(nums[low]+nums[high] > sum){
                        //System.out.println("yay");
                        high--;
                    }
                    else {
                        //System.out.println("noo");
                        low++;
                    }

                }


            }

        }
        return lists;

    }

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        //            -4, -1, -1, 0, 1, 2
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
