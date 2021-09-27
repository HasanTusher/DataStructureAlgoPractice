package com.learn.sub.pacificAtlanticWaterFlow;

import java.util.*;

public class PacificAtlanticWaterFlow {

    class Cell {
        public Integer row;
        public Integer col;

        public Cell(Integer row, Integer col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return Objects.equals(row, cell.row) &&
                    Objects.equals(col, cell.col);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    private boolean canReachBothOcean(int i, int j, int[][] heights) {
        boolean canReachPacific = false;         //column 0 row 0 ==> pacific ocean

        boolean canReachAtlantic = false;         //column (heights[r].length-1) row heights. ==> atlantic ocean

        if (i == 0 || j == 0) canReachPacific = true;
        if (i == heights.length-1 || j == heights[0].length-1) canReachAtlantic = true;


        Stack<Cell> stack= new Stack<>();
        HashSet<Cell> completed = new HashSet<>();

        Cell root= new Cell(i,j);
        stack.add(root);

        while (!stack.empty()){
            Cell current = stack.pop();
            if(!completed.contains(current)){
                if (current.row == 0 || current.col == 0){
                    canReachPacific = true;
                }
                if (current.row == heights.length-1 || current.col == heights[0].length-1)
                    canReachAtlantic = true;

                if(canReachAtlantic && canReachPacific)
                    return true;

                if(current.row-1 >= 0 && heights[current.row-1][current.col] <= heights[current.row][current.col]){
                    stack.add(new Cell(current.row-1, current.col)); // left
                }
                if(current.col-1 >=0 && heights[current.row][current.col-1] <=heights[current.row][current.col])
                {
                    stack.add(new Cell(current.row, current.col-1)); // up
                }
                if(current.row+1 < heights.length && heights[current.row+1][current.col] <= heights[current.row][current.col]){
                    stack.add(new Cell(current.row+1, current.col)); // down
                }
                if(current.col+1 < heights[0].length && heights[current.row][current.col+1] <= heights[current.row][current.col]){
                    stack.add(new Cell(current.row, current.col+1)); // right
                }

                completed.add(current);
            }

        }
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
//        boolean x = this.canReachBothOcean(3,0, heights);

        return results;
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        // {{0,4},{1,3},{1,4},{2,2},{3,0},{3,1},{4,0}}

        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        pacificAtlanticWaterFlow.pacificAtlantic(heights);
    }
}
