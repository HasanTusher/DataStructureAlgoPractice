package com.learn.sub.courseSchedule;

import java.util.HashSet;
import java.util.Stack;

public class CourseSchedule {

    private boolean checkIfCanBeCompleted(int index, int[][] prerequisites){
        HashSet<Integer> completed = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        boolean canBeCompleted = true;

        stack.push(index);
        int root = index;
        while (!stack.empty()){
            int current = stack.pop();
            if(!completed.contains(current)){
                for (int i = 0; i < prerequisites.length; i++) {
                    if(prerequisites[i][0] == current){
                        //add the other one to the
                        if (prerequisites[i][1] == root)
                            return false;
                    }
                    stack.add(prerequisites[i][1]);
                }
                completed.add(current);
            }


        }

        return canBeCompleted;


    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            boolean canBeCompleted = this.checkIfCanBeCompleted(i, prerequisites);
            if(!canBeCompleted){
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,0},{0,1}};
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean xx = courseSchedule.canFinish(2, arr);
        System.out.println(xx);
    }
}
