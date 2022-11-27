package com.learn.sub.fib;

import java.util.HashMap;

public class Fibonacci {
    private HashMap<Integer, Integer> res  = new HashMap<>();
    public int fib(int n) {
        if (n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        if(res.get(n)!=null)
            return res.get(n);
        else
        {
            int trib = fib(n-3)+fib(n-2)+fib(n-1);
            res.put(n, trib);
            return trib;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fib(4));
    }
}
