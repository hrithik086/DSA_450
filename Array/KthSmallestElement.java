/*
 * Question name- Kth Smallest Element
 * Geeks for Geeks link - https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
 */

import java.util.*;

public class KthSmallestElement{
    public static void main(String args[]){
        int arr[]={7,10,4,3,20,15};
        System.out.println(kthSmallest(arr,0,arr.length,3));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        return arr[k-1];
    } 
}