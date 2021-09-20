package com.learn.sub;

public class MaxProfit {

    public int maxProfit(int[] vals) {
        int maxProfit = 0;
        for (int i = 0; i < vals.length-1; i++) {
            for (int j = i+1; j < vals.length; j++) {
                maxProfit = Math.max(maxProfit, vals[j] -vals[i]);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
//        int[] arr = {2,1,2,0,1};
        int[] arr = {2,1,0,0,0};
        System.out.println(maxProfit.maxProfit(arr));;
    }
}
