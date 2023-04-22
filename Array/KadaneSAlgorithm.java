/*
 *                                              Kadane's Algorithm             
 * 
 * 
 * question link - https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
 * 
 * Explanation video link - https://www.youtube.com/watch?v=w4W6yya1PIc
 * 
 * in brute force method if we solve this problem it would take O(n^2) time complexity
 * but after using Kadane's algorithm it is taking O(n) time complexity
 */

public class KadaneSAlgorithm {
    public static void main(String args[]){
        int arr[]={1,2,3,-2,5};
        // int arr[]={-1,-2,-3,-4};
        long ans=maxSubArraySum(arr);
        System.out.println(ans);
    }

    public static long maxSubArraySum(int arr[]){
        long sum=0;
        long maxSum=arr[0];

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            maxSum= sum>maxSum ? sum : maxSum;
            sum= sum<0 ? 0 : sum;
        }

        return maxSum;
    }
}
