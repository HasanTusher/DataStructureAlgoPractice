package com.learn.sub;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(intervals[0][0], intervals[0][1]));
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            int previousIndex = list.size()-1;
            List<Integer> previous = list.get(previousIndex);

            //check if they overlap
            if(currentStart <= previous.get(1) || currentEnd <= previous.get(0))
            {
                //if yes then merge and push to the stack
                previous.set(0, Math.min(currentStart, previous.get(0)));
                previous.set(1, Math.max(currentEnd, previous.get(1)));
                list.remove(previousIndex);
                list.add(previous);
            }else{
                //if no then add current to the stack
                list.add(Arrays.asList(currentStart, currentEnd));
            }


        }

        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            List<Integer> tempInterval = list.get(j);
            int[] ints = new int[2];
            ints[0] = tempInterval.get(0);
            ints[1] = tempInterval.get(1);
            res[j] = ints;
        }


        for (int j = 0; j < res.length; j++) {
            System.out.println(Arrays.toString(res[j]));
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,4}, {0,0}};
        MergeInterval mergeInterval = new MergeInterval();
        mergeInterval.merge(intervals);
    }
}
