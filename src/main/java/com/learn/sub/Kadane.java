package com.learn.sub;

public class Kadane {

    public int shortestSubarray(int[] nums, int k) {
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for(int i=0; i<nums.length; i++){

            maxEndingHere +=nums[i];

            if(maxEndingHere < 0 )
                maxEndingHere = 0;
            else
            {
                if(maxSoFar < maxEndingHere)
                    maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;

    }

    public static void main(String[] args) {
//        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr[] = {-2, -3, 10, 1, -10};

        Kadane kadane  = new Kadane();
        int res = kadane.shortestSubarray(arr, arr.length);
        System.out.println(res);
    }
}
