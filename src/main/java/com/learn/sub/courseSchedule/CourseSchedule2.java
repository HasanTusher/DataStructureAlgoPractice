package com.learn.sub.courseSchedule;

import java.util.*;

public class CourseSchedule2 {

    private boolean checkIfCanBeCompleted(int index, HashMap<Integer, HashSet<Integer>> prerequisites){
        HashSet<Integer> completed = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        boolean canBeCompleted = true;

        stack.add(index);
        int root = index;
        while (!stack.isEmpty()){
            int current = stack.pop();
            if(!completed.contains(current)){
                HashSet<Integer> integers = prerequisites.get(current);
                Iterator<Integer> integerIterator = integers.iterator();
                while (integerIterator.hasNext()){
                    int temp = integerIterator.next();
                    if(temp == root)
                        return false;
                    stack.add(temp);
                }
                completed.add(current);
            }


        }

        return canBeCompleted;


    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        for(int i=0;i<numCourses; i++){
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (Map.Entry mapElement : graph.entrySet()) {
            Integer key = (Integer)mapElement.getKey();
            boolean xx = this.checkIfCanBeCompleted(key, graph);
            if(!xx)return false;

        }

        return true;
    }

    public static void main(String[] args) {
//        3
//                [[1,0],[2,1]]
        int arr[][] = {{1,0},{0,1}};
        CourseSchedule2 courseSchedule = new CourseSchedule2();
        boolean xx = courseSchedule.canFinish(2, arr);
        System.out.println(xx);
    }
}
