package com.learn.sub.reverseBits;

public class ReverseBits {
    public int reverseBits(int n) {

        int res = 0;
        int pos = 0;
        for (int i = 0; i <32 ; i++) {
            int ithBit = this.getIthBit(n, i);
            res <<= 1; //move a single bit to left
            if(ithBit == 1){
                res |=1; //add one to the right
            }

        }
        return  res;
    }

    private int getIthBit(int n, int i) {
        int x = n & (1 << i);
        if(x!=0){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits =new ReverseBits();
        System.out.println(reverseBits.reverseBits(3));;
    }
}
