package com.learn.sub;

import java.util.Arrays;

public class Kadane {

    public void print(int [] axx){
        //for(int i=0; i< axx.length; i++){
            for(int j=0; j< axx.length; j++){
                System.out.print(axx[j]+" ");
            }
            System.out.print("\n");
//        }
    }

    public int shortestSubarray(int[] nums, int k) {

        //create a 2d array

        int[] arr = new int[nums.length];


        for(int i=0;i<arr.length;i++){
            if(nums[i] >= k )
                return 1;
            arr[i] = nums[i];
        }

        for(int i=1;i< arr.length; i++){
            for(int j=0; j< arr.length-i; j++){

                    int temp = arr[j]+nums[j+i];
                    if(temp>= k)
                        return i+1;
                    arr[j] = temp;
//                }
            }
            this.print(arr);
        }
        //this.print(arr);
        return -1;

    }

    public static void main(String[] args) {
//        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr[] = {-2, -3, 10, 1, -10};

        Kadane kadane  = new Kadane();
        int res = kadane.shortestSubarray(arr, 20);
        System.out.println(res);
    }
}
