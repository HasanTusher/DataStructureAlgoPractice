package com.learn.sub.removeDuplicate;

import java.util.*;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);

//            nums[i] = integerIterator.next();
        }


        Iterator<Integer> integerIterator = set.iterator();
//        while (integerIterator.hasNext()){
//            System.out.println(integerIterator.next());
//        }


        for (int i = 0; i < set.size(); i++){
//            set.add(nums[i]);

            nums[i] = integerIterator.next();
        }
//        System.out.println(Arrays.toString(nums));
        return set.size();

    }

    public static void main(String[] args) {
         int[] aa = {0,0,1,1,1,2,2,3,3,4};

         RemoveDuplicates removeDuplicates = new RemoveDuplicates();

         removeDuplicates.removeDuplicates(aa);

    }
}
