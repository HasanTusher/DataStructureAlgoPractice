package com.learn.sub.segment;

import java.util.Arrays;

public class SegmentTree {



    public void createSegmentTree(int[] arr){

        int segTreeLength = arr.length * 2;
        int segmentTree[] = new int[segTreeLength];
        for (int i = arr.length-1; i >= 0; i--) {
            segmentTree[arr.length+i] = arr[i];
        }

        for(int i = arr.length-1; i>0; i--){
            segmentTree[i] = Math.max(segmentTree[2*i], segmentTree[2*i+1]);
        }


        System.out.println(Arrays.toString(segmentTree));

    }

    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree();
        int[] arr = {1,2,4,5,7,8};
        segmentTree.createSegmentTree(arr);

    }
}
