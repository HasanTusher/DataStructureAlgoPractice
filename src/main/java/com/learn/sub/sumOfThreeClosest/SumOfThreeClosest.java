package com.learn.sub.sumOfThreeClosest;

import com.learn.sub.sumOfThree.SumOfThree;

public class SumOfThreeClosest {
    public int threeSumClosest(int[] nums, int target) {

        int maxDistance = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length -2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int tempSum = nums[i]+nums[j]+nums[k];
                    int distance = Math.abs(tempSum - target );
                    if(distance < maxDistance)
                    {
                        sum = tempSum;
                        maxDistance = distance;
                    }
                    if(maxDistance == 0)
                        return sum;
                    //System.out.println("sum: "+ tempSum+"; distance: "+distance);

                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] ={-1,2,1,-4};
        int target = 1;
        SumOfThreeClosest sumOfThreeClosest = new SumOfThreeClosest();
        int res = sumOfThreeClosest.threeSumClosest(arr, target);
        System.out.println("result "+ res);
    }
}
