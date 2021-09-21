package com.learn.sub.segment;

import java.util.Arrays;

public class SegmentTree {

    private int[] tree;
    private int[] arr;
    private int n;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        this.tree = new int[2*n];
        this.createSegmentTree(arr);
    }

    public void createSegmentTree(int[] arr){

        int segTreeLength = arr.length * 2;
        //int segmentTree[] = new int[segTreeLength];
        System.arraycopy(this.arr, 0, this.tree, n, n);

        for(int i = arr.length-1; i>0; i--){
            this.tree[i] = Math.max(this.tree[2*i], this.tree[2*i+1]);
        }
        System.out.println(Arrays.toString(this.tree));

    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,7,8};
        SegmentTree segmentTree = new SegmentTree(arr);
        //segmentTree.createSegmentTree(arr);

    }
}
