package com.learn.sub.productExceptSelf;

import com.learn.sub.fenwick.FenwickTree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductExceptSelf {


    public int[] productExceptSelf(int[] nums) {
        int[] forwardRes = new int[nums.length];
        int[] backWardRes = new int[nums.length];
        int res[]  = new int[nums.length];
        forwardRes[0] =1;
        for (int i = 1; i < nums.length; i++) {
            forwardRes[i] = forwardRes[i-1] * nums[i-1];
        }

        backWardRes[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            backWardRes[i] = backWardRes[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = forwardRes[i]*backWardRes[i];
        }
        System.out.println(Arrays.toString(forwardRes));
        System.out.println(Arrays.toString(backWardRes));
        return res;


    }


    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        ProductExceptSelf productExceptSelf =new ProductExceptSelf();
        productExceptSelf.productExceptSelf(nums);
        //System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(nums)));
    }
}
