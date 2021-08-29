package com.learn.sub;

import java.util.Arrays;

public class Kadane {

    public void print(int [][] axx){
        for(int i=0; i< axx.length; i++){
            for(int j=0; j< axx[i].length; j++){
                System.out.print(axx[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public int shortestSubarray(int[] nums, int k) {

        //create a 2d array

        int arr[][] = new int[nums.length][nums.length];

        for(int i=0;i< arr.length; i++){

            for(int j=0; j< arr[i].length-i; j++){

                if(i==0){
                    if(nums[j] >= k )
                        return 1;
                    arr[i][j] = nums[j];
                }
            }


        }
        this.print(arr);



        return 0;

    }

    public static void main(String[] args) {
//        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr[] = {-2, -3, 10, 1, -10};

        Kadane kadane  = new Kadane();
        int res = kadane.shortestSubarray(arr, 20);
        System.out.println(res);
    }
}
