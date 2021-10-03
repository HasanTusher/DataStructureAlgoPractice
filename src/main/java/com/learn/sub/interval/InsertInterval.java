package com.learn.sub.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        //int[][] res= new int[newInterval.length][2];
        List<List<Integer>> lists = new ArrayList<>();
        //1. find the starting position of the new interval
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] <= newInterval[0] && intervals[i][1] >=newInterval[0])
            {
                System.out.println("Here");
                System.out.println(i);
                break;
            }
            else if(intervals[i][0] >= newInterval[0] && intervals[i][1] >=newInterval[1])
            {
                System.out.println("there");
                System.out.println(i);
                break;
            }
            else if(intervals[i][0] >= newInterval[0]){
                System.out.println("yaya");
                System.out.println(i);
                break;
            }

        }

        return null;
    }
    public static void main(String[] args) {

//        int[][] intervals = {{1,3},{6,9}};
        int[][] intervals = {{1,3},{4,6}, {10,12}};
        int[] newInterval = {4, 10};


        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(intervals, newInterval);
    }
}
