package com.learn.sub.segment;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SegmentTree {

    private int[] tree;
    private int[] arr;
    private int n;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        this.tree = new int[2*n];
        this.createMaxSegmentTree(arr);
    }

    public int findMax(int start, int end){
        //add +1 to end
        start+=this.n;
        end+=this.n;
        if(start==end)
            return this.arr[start];
        int max = Integer.MIN_VALUE;

        while (start < end){
            if((start & 1) == 1){ //start is odd
                max = Math.max(this.tree[start], max);
                start++;
            }
            if((end & 1) == 1){
                end--;
                max = Math.max(this.tree[end], max);
            }

            start >>=1;
            end >>=1;
        }

        return max;


    }

    public void createMaxSegmentTree(int[] arr){
        System.arraycopy(this.arr, 0, this.tree, n, n);
        for(int i = arr.length-1; i>0; i--){
            this.tree[i] = Math.max(this.tree[2*i], this.tree[2*i+1]);
        }
        System.out.println(Arrays.toString(this.tree));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,7,8};
        SegmentTree segmentTree = new SegmentTree(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(segmentTree.findMax(0, arr.length-i));
        }

    }
}
