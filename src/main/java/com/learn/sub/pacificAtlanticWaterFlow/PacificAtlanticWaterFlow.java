package com.learn.sub.pacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    private boolean canReachBothOcean(int i, int j, int[][] heights) {
        boolean canReachPacific = false;         //column 0 row 0 ==> pacific ocean

        boolean canReachAtlantic = false;         //column (heights[r].length-1) row heights. ==> atlantic ocean

        if (i == 0 || j == 0) canReachPacific = true;
        if (j == heights[0].length-1 || i == heights.length-1) canReachAtlantic = true;

        return canReachAtlantic && canReachPacific;

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (this.canReachBothOcean(i, j, heights)) {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(i);
                    integers.add(j);
                    results.add(integers);
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        // {{0,4},{1,3},{1,4},{2,2},{3,0},{3,1},{4,0}}

        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        pacificAtlanticWaterFlow.pacificAtlantic(heights);
    }
}
