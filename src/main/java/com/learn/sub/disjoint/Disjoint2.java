package com.learn.sub.disjoint;

public class Disjoint2 {
    public int createDisjoint(int[] vals) {
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        boolean isDescending = true;
//        for (int i = 0; i < vals.length-1; i++) {
//            max = Math.max(vals[i+1], max);
//            min = Math.min(vals[i], min);
//            if(vals[i] < vals[i+1])
//                isDescending = false;
//        }
//
//        return isDescending ? 0 : max-min;
        return 0;
    }

    public static void main(String[] args) {
        Disjoint2 disjoint2 = new Disjoint2();
        int arr[] ={5,1,3,10,7};
        System.out.println(disjoint2.createDisjoint(arr));
    }
}
