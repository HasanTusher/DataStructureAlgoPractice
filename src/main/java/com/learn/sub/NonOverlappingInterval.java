package com.learn.sub;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public  class NonOverlappingInterval{
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int latestValidIndex = 0;
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {

            if(intervals[i][0] < intervals[latestValidIndex][1]){
            {
                res++;
                if(intervals[i][1] < intervals[latestValidIndex][1])
                    latestValidIndex = i;

            }

            }
            else
                latestValidIndex = i;
        }
        return res;
    }

    private int calculateSize(int i, int i1) {
        if(i < 0){
            return Math.abs(i-i1);
        }else
            return i1-i;
    }

    public static void main(String[] args) {
//        [[1,100],[11,22],[1,11],[2,12]]
       int[][] intervals =  {{-52,31},
               {-73,-26},
               {82,97},
               {-65,-11},
               {-62,-49},
               {95,99},
               {58,95},
               {-31,49},
               {66,98},
               {-63,2},
               {30,47},
               {-40,-26}};
//        int intervals[][] = {{1,100}, {11,22}, {1, 11}, {2, 12}};
        NonOverlappingInterval nonOverlappingInterval = new NonOverlappingInterval();
        nonOverlappingInterval.eraseOverlapIntervals(intervals);

    }
}


