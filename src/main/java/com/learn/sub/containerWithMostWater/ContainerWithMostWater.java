package com.learn.sub.containerWithMostWater;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int leftPointer = 0;
        int rightPointer = height.length -1;
        int maxArea = 0;

        while (leftPointer < rightPointer){
            if(height[leftPointer] < height[rightPointer])
            {
                maxArea = Math.max(maxArea, (height[leftPointer]*(rightPointer-leftPointer)));
                leftPointer++;
            }else
            {
                maxArea = Math.max(maxArea, (height[rightPointer]*(rightPointer - leftPointer)));
                rightPointer--;
            }
            //return maxArea;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(containerWithMostWater.maxArea(height));
    }
}
