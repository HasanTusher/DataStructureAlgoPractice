package com.learn.sub;

import java.util.Arrays;

public class MaxProfit {

    private int max(int[] tree, int[] ints, int from, int to, int size){
        if(from == to)
            return ints[from];
        from += size; // go to second half of the array
        to += size;
        int max = Integer.MIN_VALUE;

        while (from < to) {
            if ((from & 1) == 1) { // 'from' is odd, so it is the right child of its parent, then interval includes node 'from' but doesn't include its parent
                max = Math.max(max, tree[from]);
                from++;
            }
            if ((to & 1) == 1) { // 'to' is odd, so it's the right child of its parent, then might as well use the parent
                to--;
                max = Math.max(max, tree[to]);
            }
            from >>= 1; // shift right is the same as divide by 2 but a little faster
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
