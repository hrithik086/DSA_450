/*
 * Question link - https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 * Explanation Video Link - https://www.youtube.com/watch?v=m18Hntz4go8&ab_channel=takeUforward
 */

import java.util.Arrays;

public class TrappingRainWater{
    public static void main(String args[]){
        // int arr[]={3,0,0,2,0,4};
        int arr[]={7,4,0,9};
        // int arr[]={6,9,9};
        System.out.println(trappingWater(arr, arr.length));
    }

    static long trappingWater(int arr[], int n) { 
        // Your code here
        int leftMax[]=new int[arr.length];
        int rightMax[]=new int[arr.length];
        int min;
        long sum=0;
        leftMax[0]=0;
        rightMax[arr.length-1]=0;
        
        for(int i=1,j=arr.length-2;i<arr.length && j>=0;i++,j--){
            leftMax[i]=Math.max(leftMax[i-1],arr[i-1]);
            rightMax[j]=Math.max(arr[j+1],rightMax[j+1]);
        }
        
        // System.out.println(Arrays.toString(leftMax));
        // System.out.println(Arrays.toString(rightMax));
        
        for(int i=0;i<arr.length;i++){
           min=Math.min(leftMax[i],rightMax[i]);
           sum+= min-arr[i] > 0 ? min-arr[i] : 0; 
        }
        
        
        return sum;
        
    }
}