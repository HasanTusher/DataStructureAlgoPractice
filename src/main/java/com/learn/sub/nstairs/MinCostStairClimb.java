package com.learn.sub.nstairs;

public class MinCostStairClimb {


    int calculateMinCost(int[] cost, int n){
        for (int i = 2; i < n; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[n-1], cost[n-2]);
    }

    public int minCostClimbingStairs(int[] cost) {
        return this.calculateMinCost(cost, cost.length);
    }

    public static void main(String[] args) {
        int[] arr= {10,15,20};

        MinCostStairClimb minCostStairClimb = new MinCostStairClimb();
        System.out.println(minCostStairClimb.minCostClimbingStairs(arr));
    }
}
