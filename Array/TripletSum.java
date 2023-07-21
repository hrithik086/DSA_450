/*
 * Question link - https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
 * Explanation Video Link - https://www.youtube.com/watch?v=o7HykueZVs4&ab_channel=GeeksforGeeks
 * This is two pointer approach
 */

import java.util.Arrays;

public class TripletSum {
    public static void main(String args[]){
        // int arr[]={1 ,4 ,45 ,6 ,10 ,8};
        // int X=13;
        int arr[]={1 ,2 ,4 ,3 ,6};
        int X=10;
        System.out.println(find3Numbers(arr, arr.length, X));
    }

    public static boolean find3Numbers(int A[], int n, int X) { 
    
        // Your code Here
        int temp=0;
        int left=0;
        int right=0;
        int sum=0;
        
        Arrays.sort(A);
        
        for(int i=0;i<A.length;i++){
            temp=X-A[i];
            left=i+1;
            right=A.length-1;
            while(left<right){
                sum=A[left]+A[right];
                if(sum==temp){
                    return true;
                }
                else if(sum < temp){
                    left++;
                }
                else if(sum > temp){
                    right--;
                }
            }
        }
        
        return false;
     
     }
}
