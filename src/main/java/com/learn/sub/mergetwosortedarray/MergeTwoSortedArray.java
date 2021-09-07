package com.learn.sub.mergetwosortedarray;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left =0;
        int right = 0;
        int index =0;
        int[] res = new int[m+n];

        while (left < m && right < n){
            if(nums1[left]< nums2[right]){
                res[index] = nums1[left];
                left++;
                index++;
            }else{
                res[index] = nums2[right];
                right++;
                index++;
            }
        }

        while (right < n){
            res[index] = nums2[right];
            right++;
            index++;
//            nums1[left] = nums2[right];
//            left++;
//            right++;
        }
        while (left < m){
            res[index] = nums1[left];
            left++;
            index++;
        }

        for(int i=0;i <(m+n); i++){
            nums1[i] = res[i];
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
