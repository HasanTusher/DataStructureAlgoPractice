package com.learn.sub;

import com.learn.sub.courseSchedule.CourseSchedule;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedulingTopological {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        //indegree array
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        int resIndex = 0;
        while (!queue.isEmpty()){
            int root = queue.poll();
            res[resIndex] = root;
            resIndex++;

            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1]== root)
                {
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0)
                        queue.add(prerequisites[i][0]);
                }
            }
        }

        if(resIndex!=numCourses)
            return  new int[0];
        
        return res;

    }
    public static void main(String[] args) {
        int numCourses = 4;
//        int numCourses = 1;
        int prerequisites[][] ={{1,0},{2,0},{3,1},{3,2}};
//         int numCourses = 2;
//        int prerequisites[][] = {{0,1},{1,0}};
//         ={};
        CourseSchedulingTopological courseSchedule =new CourseSchedulingTopological();
        int res[] = courseSchedule.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(res));
    }
}
