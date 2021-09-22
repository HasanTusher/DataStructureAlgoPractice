package com.learn.sub;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }
        return integers.first();
    }

    public int search(int[] nums, int target) {
        TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            integerIntegerTreeMap.put(nums[i], i);
        }

        return integerIntegerTreeMap.get(target) == null ? -1: integerIntegerTreeMap.get(target);

    }
    public static void main(String[] args) {
        int[] ints = {3,4,5,1,2};
        MinimumInRotatedSortedArray minimumInRotatedSortedArray = new MinimumInRotatedSortedArray();
        minimumInRotatedSortedArray.findMin(ints);
    }
}
