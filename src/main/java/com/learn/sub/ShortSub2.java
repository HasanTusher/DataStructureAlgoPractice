package com.learn.sub;

public class ShortSub2 {

    private int getResult(int nums[], int k, int start, int last){
        if(start == last){
            if(nums[start] < k)
                return -1;
            return  1;
        }

        int sumOfLeftSubArray = this.getResult(nums, k, start, last-1);
        int sumOfRightSubArray = this.getResult(nums, k, start+1, last);

        if(sumOfLeftSubArray == -1 && sumOfRightSubArray ==-1)
        {
            int total = 0;
            for(int i=start; i<=last; i++ ){
                total+=nums[i];
            }

            if(total < k)
                return -1;
            return (last-start)+1;
        }else if(sumOfLeftSubArray == -1){
            return sumOfRightSubArray;
        }else if(sumOfRightSubArray == -1){
            return sumOfLeftSubArray;
        }

        return Math.min(sumOfLeftSubArray, sumOfRightSubArray);
    }

    public int shortestSubarray(int[] nums, int k) {

        return this.getResult(nums, k, 0, nums.length-1);
    }

    public static void main(String[] args) {


        //209110
        ShortSub2 s = new ShortSub2();
        //int arr[] = {1,2,3,4,5,10,1};
        int arr[] = {86396,74204,24861,72405,30809,40710,47892,-48882,-9084,59464,29389,1510,16521,38996,98830,15183,38241,90465,-10717,81061,-40387,-23424,74146,-24051,56847,44278,41403,-763,50836,6482,44225,16178,-48529,-36193,28857,-16654,48188,54971,-29822,25959,90144,-23182,-9464,65609,99248,-26248,47993,-20085,75072,70400};
//        int arr[] = {86396,74204,24861,72405,30809,40710,47892,-48882,-9084,59464,29389,1510,16521,38996};
        int ans = s.shortestSubarray(arr, 209110);
        System.out.println(ans);

    }
}
