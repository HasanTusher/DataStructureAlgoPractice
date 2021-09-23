package com.learn.sub.countingBits;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int n) {
        int res[] =new int[n+1];

        for (int i = 0; i < n+1; i++) {
            res[i] = this.countActiveBits(i);
        }
        return res;
    }

    private int countActiveBits(int n) {
        int res = 0;
        for (int i=0; i<32; i++){
            int x = n & (1 << i);
            if(x !=0){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();

        System.out.println(Arrays.toString(countingBits.countBits(2)));
    }
}
