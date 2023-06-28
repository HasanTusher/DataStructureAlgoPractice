package com.learn.sub;

import java.util.Arrays;

;
public class MaxProfit {

    private int max(int[] tree, int[] ints, int from, int to, int size){
        if(from == to)
            return ints[from];
        from += size;
        to += size;
        int max = Integer.MIN_VALUE;

        while (from < to) {
            if ((from & 1) == 1) {
                max = Math.max(max, tree[from]);
                from++;
            }
            if ((to & 1) == 1) {
                to--;
                max = Math.max(max, tree[to]);
            }
            from >>= 1;
            to >>= 1;
        }

        return max;
    }

    public int maxProfit(int[] prices) {
        int size = prices.length;
        //create a segment tree for finding max
        int tree[] = new int[2*size];
        System.arraycopy(prices, 0, tree, size, size);

        for (int i = size-1; i >0 ; i--) {
            tree[i] = Math.max(tree[2*i], tree[2*i+1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size-1; i++) {
            max = Math.max(this.max(tree,prices, i+1, size, size)-prices[i], max);
        }
        return Math.max(max, 0);
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] arr = {2,1,2,0,1};
//        int[] arr = {2,1,0,0,0};
        System.out.println(maxProfit.maxProfit(arr));;
    }
}
