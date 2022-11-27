package com.learn.sub.hammingWeight;


public class HammingWeight {

    public int hammingWeight(int n) {
        int cursor=0;
        int length = 0;
//        n =  n;
        System.out.println( n & (1 << 2));
        for (int i = 0; i < 32; i++) {
            int x = (n & (1 << i));
            if(x != 0)
            {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(31));
    }
}
