/*
 * Question link - https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1
 * Explanation video link1 - https://www.youtube.com/watch?v=hnswaLJvr6g&ab_channel=takeUforward
 * link 1 if for maxProduct() method
 */

public class MaximumProductSubarray {
    public static void main(String args[]){
        int arr[]={6,-3,-10,0,2};
        MaximumProductSubarray mps=new MaximumProductSubarray();
        System.out.println(mps.maxProduct(arr,arr.length));
    }

    long maxProduct(int[] arr, int n) {
        long prefixProduct=1;
        long suffixProduct=1;
        long prefixMax=Integer.MIN_VALUE;
        long suffixMax=Integer.MIN_VALUE;
        
        for(int i=0,j=arr.length-1;i<arr.length && j>=0;i++,j--){
            prefixProduct*=arr[i];
            prefixMax=Math.max(prefixMax, prefixProduct);
            prefixProduct = prefixProduct == 0 ? 1 : prefixProduct;
            
            suffixProduct*=arr[j];
            suffixMax=Math.max(suffixMax, suffixProduct);
            suffixProduct = suffixProduct == 0 ? 1 : suffixProduct;
        }
        
        return Math.max(prefixMax, suffixMax);
    }
}
