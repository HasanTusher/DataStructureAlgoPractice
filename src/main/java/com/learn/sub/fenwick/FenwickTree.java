package com.learn.sub.fenwick;

import java.util.Arrays;

public class FenwickTree {

    private int arr[];
    private int tree[];
    private int n;
    public FenwickTree(int[] arr) {
        this.arr = arr;
        this.n = this.arr.length;
        this.tree = new int[n];
        this.createFenwickTree();
    }

    private void createFenwickTree() {
        System.arraycopy(arr, 0, this.tree, 0, n);
        System.out.println(Arrays.toString(this.tree));
        for (int i = 1; i < n; i++) {
            int p = i+ (i & -i); //index of parent
            if(p < n){
                this.tree[p] = this.tree[p] + this.tree[i];
            }
        }

    }

    public int sum(int from, int to){
        int sum = 0;
        while (from < to){
            sum+=this.tree[to];
            to-=(to & -to);
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {0, 5, 2, 9, -3, 5, 20, 10, -7, 2, 3, -4, 0, -2, 15, 5};
        FenwickTree fenwickTree =new FenwickTree(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(fenwickTree.sum(0, i));
            //System.out.println(fenwickTree.sum( i));
        }
    }

}
