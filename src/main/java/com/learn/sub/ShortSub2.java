package com.learn.sub;

import java.util.Arrays;

public class ShortSub2 {



    public int shortestSubarray(int[] nums, int k) {
        int shortestLength=-1;
        for(int i = 0; i< nums.length; i++){
            int sum = 0;
            int lengthOfSubArray=-1;

            for (int j=i; j<nums.length; j++){
                if(sum<k)
                {
                    sum+=nums[j];
                }
                if(sum >= k){
                    lengthOfSubArray = (j-i)+1;
                    //System.out.println("j: "+j);
                    //System.out.println("i: "+i);
                    break;
                }
            }

            if(i==0 && sum < k) { //will never happen
                return -1;
            }

            if(shortestLength == -1){
                shortestLength = lengthOfSubArray;
            }else if(lengthOfSubArray != -1){
                //System.out.println("shortest length:" +shortestLength);
                //System.out.println("subarray lenght:" +lengthOfSubArray);
                shortestLength = Math.min(shortestLength, lengthOfSubArray);
            }
            else{
//                System.out.println("shortest length:" +shortestLength);
//                System.out.println("subarray lenght:" +lengthOfSubArray);
//                shortestLength = Math.min(shortestLength, lengthOfSubArray);

            }
        }
        return shortestLength ;
    }

    public static void main(String[] args) {


        //209110
        ShortSub2 s = new ShortSub2();
        int arr[] = {1,-2,8,4,5,10};
//        int arr[] = {1};
//        int arr[] = [86396,74204,24861,72405,30809,40710,47892,-48882,-9084,59464,29389,1510,16521,38996,98830,15183,38241,90465,-10717,81061,-40387,-23424,74146,-24051,56847,44278,41403,-763,50836,6482,44225,16178,-48529,-36193,28857,-16654,48188,54971,-29822,25959,90144,-23182,-9464,65609,99248,-26248,47993,-20085,75072,70400];
//        int arr[] = {86396,74204,24861,72405,30809,40710,47892,-48882,-9084,59464,29389,1510,16521,38996};
        int ans = s.shortestSubarray(arr, 11);
        System.out.println(ans);

    }
}
