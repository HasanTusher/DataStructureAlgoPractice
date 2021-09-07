package com.learn.sub.reverse;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left =0;
        int right = 0;

        while (left < m && right < n){
            if(nums1[left] > nums2[right]){
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
            }
            left++;
        }

        while (right < n){
            nums1[left] = nums2[right];
            left++;
            right++;
        }

    }

    public static void main(String[] args) {
//        int nums1[] = {1,2,3,0,0,0};
//        int m = 3;
//        int nums2[] = {2,5,6};
//        int n = 3;

        int nums1[] = {4,5,6,0,0,0};
         int m = 3;
        int nums2[] = {1,2,3};
        int n =3;
        MergeTwoSortedArray mergeTwoSortedArray =new MergeTwoSortedArray();
        mergeTwoSortedArray.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}
