package com.learn.sub.nstairs;

import java.util.HashMap;

public class Nstairs {

    private HashMap<Integer, Integer> res  = new HashMap<>();

    public int climbStairs(int n) {
        return this.fib(n+1);
    }
    //0 1 1 2 3
    //1 2 3 4 5
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(res.get(n)!=null)
            return res.get(n);
        else
        {
            int fib = fib(n-2)+fib(n-1);
            res.put(n, fib);
            return fib;
        }
    }

    public static void main(String[] args) {
        Nstairs nstairs = new Nstairs();
        System.out.println(nstairs.climbStairs(1));
    }
}
