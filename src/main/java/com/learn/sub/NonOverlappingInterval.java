package com.learn.sub;

import java.util.Arrays;
import java.util.Comparator;

public  class NonOverlappingInterval{
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt((int[] arr) -> arr[1]-arr[0]));
        int latestValidIndex = 0;
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[latestValidIndex][0] > intervals[i][1] || intervals[latestValidIndex][1] > intervals[i][0]){
                res++;
            }else
                latestValidIndex = i;
        }
        return res;
    }
    public static void main(String[] args) {
//        [[1,100],[11,22],[1,11],[2,12]]
        int intervals[][] = {{1,100}, {11,22}, {1, 11}, {2, 12}};
        NonOverlappingInterval nonOverlappingInterval = new NonOverlappingInterval();
        nonOverlappingInterval.eraseOverlapIntervals(intervals);

    }
}


