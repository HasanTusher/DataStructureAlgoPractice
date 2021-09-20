package com.learn.sub.disjoint;

public class Disjoint2 {
    public int createDisjoint(int[] vals) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < vals.length-1; i++) {
            max = Math.max(vals[i+1], max);
            min = Math.min(vals[i], min);
        }

        return max-min;
    }

    public static void main(String[] args) {
        Disjoint2 disjoint2 = new Disjoint2();
//        int arr[] ={7,1,5,3,6,4};
        int arr[] ={7,6,4,3,1};
        System.out.println(disjoint2.createDisjoint(arr));
    }
}
