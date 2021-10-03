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
                List<List<Integer>> lists1 = this.handleInMiddle(i, intervals, newInterval);
                lists.addAll(lists1);
                break;
            }
            else if(intervals[i][0] >= newInterval[0] && intervals[i][1] >=newInterval[1])
            {
                List<List<Integer>> lists1 = this.handleBetweenTwo(i, intervals, newInterval);
                lists.addAll(lists1);
                break;
            }
            else if(intervals[i][0] >= newInterval[0]){
                List<List<Integer>> lists1 = this.handleLeft(i, intervals, newInterval);
                lists.addAll(lists1);
//                break;
                break;
            }else
            {
                lists.add(this.addInterval(intervals[i][0], intervals[i][1])); //add this to the queue
            }

        }


        int[][] res = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            res[i][0] = lists.get(i).get(0);
            res[i][1] = lists.get(i).get(1);
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        return res;
    }

    private List<List<Integer>> handleLeft(int i, int[][] intervals, int[] newInterval) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(newInterval[0]);
        int upper = newInterval[1];
        int ending  = 0;
        for (int j = i; j < intervals.length; j++) { //loop through and find the appropiate ending
            int tempLower = intervals[j][0];
            int tempUpper = intervals[j][1];
            if(tempLower > upper)
            {
                integers.add(upper);
                ending = j;
            }else if(upper >=tempLower && upper <=tempUpper){
                integers.add(tempUpper);
                ending = j;
            }else if(j == intervals.length-1 && upper > tempUpper){
                integers.add(upper);
                ending = j;
            }
        }

        lists.add(integers);
        for (int j = ending; j < intervals.length ; j++) {
            lists.add(Arrays.asList(intervals[j][0], intervals[j][1]));
        }
        return lists;
    }

    private List<List<Integer>> handleBetweenTwo(int i, int[][] intervals, int[] newInterval) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers = this.addInterval(newInterval[0], newInterval[1]);
        lists.add(integers);
        for (int j = i; j <intervals.length ; j++) {
            lists.add(Arrays.asList(intervals[i][0], intervals[i][1]));
        }
        return lists;
    }

    private List<List<Integer>> handleInMiddle(int i, int[][] intervals, int[] newInterval) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(intervals[i][0]);
        int upper = newInterval[1];
        int ending  = 0;
        for (int j = i; j < intervals.length; j++) { //loop through and find the appropiate ending
            int tempLower = intervals[j][0];
            int tempUpper = intervals[j][1];
            if(tempLower > upper)
            {
                integers.add(upper);
                ending = j;
            }else if(upper >=tempLower && upper <=tempUpper){
                integers.add(tempUpper);
                ending = j;
            }else if(j == intervals.length-1 && upper > tempUpper){
                integers.add(upper);
                ending = j;
            }
        }

        lists.add(integers);
        for (int j = ending; j < intervals.length ; j++) {
            lists.add(Arrays.asList(intervals[j][0], intervals[j][1]));
        }
        return lists;

    }

    private List<Integer> addInterval(int i, int i1) {
        return  Arrays.asList(i, i1);
    }

    public static void main(String[] args) {

//        int[][] intervals = {{1,3},{6,9}};
//        int[][] intervals = {{1,3},{4,6}, {10,12}};
        int[][] intervals= {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4, 8};


        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(intervals, newInterval);
    }
}
