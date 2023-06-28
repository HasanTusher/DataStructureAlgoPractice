package com.learn.sub.climbingStairs;

import java.util.HashMap;

public class ClimbingStair {

    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if (n==2)
            return 2;
        int leftSubTreeResult, rightSubTreeResult;
        //check if left subtree val exists in cache
        if(cache.get(n - 1) == null)
        {
            leftSubTreeResult = climbStairs(n-1);
            //put in cache
            cache.put(n-1, leftSubTreeResult);
        }else
            leftSubTreeResult = cache.get(n-1);

        if(cache.get(n - 2) == null)
        {
            rightSubTreeResult = climbStairs(n-2);
            //put in cache
            cache.put(n-2, rightSubTreeResult);
        }else
            rightSubTreeResult = cache.get(n-2);


        return leftSubTreeResult+rightSubTreeResult;

    }
    public static void main(String[] args) {
        ClimbingStair climbingStair = new ClimbingStair();
        System.out.println(climbingStair.climbStairs(45));
    }
}
