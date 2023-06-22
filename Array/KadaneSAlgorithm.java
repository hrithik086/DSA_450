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
        // int arr[]={1,2,3,-2,5};
        int arr[]={-1,-2,-3,-4};
        long ans=maxSubArraySum(arr);
        System.out.println(ans);
    }

    //this is the approach without explanation comment and startIndex and endIndex
    // public static long maxSubArraySum(int arr[]){
    //     long sum=0;
    //     long maxSum=arr[0];

    //     for(int i=0;i<arr.length;i++){
    //         sum+=arr[i];
    //         maxSum= sum>maxSum ? sum : maxSum;
    //         sum= sum<0 ? 0 : sum;
    //     }

    //     return maxSum;
    // }

    //this is the same approach with explanation comments and startIndex and endIndex
    public static long maxSubArraySum(int arr[]){
        long sum=0;
        long maxSum=Long.MIN_VALUE;
        int startIndex=0, endIndex=0; //to maintain the starting and ending index of contiguous subarray
        int maxStartIndex=0, maxEndIndex=0; //this for strong start and end of max sub array
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            maxSum=Math.max(sum,maxSum);
            
            //as long as maxsum is increasing endIndex of contiguous subrarray will increase
            if(maxSum==sum){
                maxEndIndex=i;
                endIndex=i;
                maxStartIndex=startIndex;
            }
            
            //if sum becomes negative it can,t give maximum sum so we need to make it zero
            //if adding this element made my whole sum negative that means using this element we can't get maxSubarray
            //so it is better to stop the current subarray sum till the previous element to this element 
            //and start a new subarray from the next element to this element so this is the reason why we need to make sum=0
            if(sum<0){
                //if we are making sum as zero that means we are ending one subarray and we are about to start new subarray
                sum=0;
                
                //as we are ending one subarray and starting another subarray we need to change the pointer
                //of startIndex to next to present index because present index is end of one subarray
                startIndex= (i+1)<arr.length ? (i+1) : startIndex;
            }
            
        }
        
        System.out.println("start index of subarray ="+maxStartIndex);
        System.out.println("end index of subarray ="+maxEndIndex);
        return maxSum;
        
    }
}
