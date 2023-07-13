/*
 * Question link - https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1
 * Explanation video link1 - https://www.youtube.com/watch?v=hnswaLJvr6g&ab_channel=takeUforward
 * link 1 if for maxProduct() method
 * Explanation video link2 - https://www.youtube.com/watch?v=tHNsZHXnYd4&t=523s&ab_channel=Yogesh%26Shailesh%28CodeLibrary%29
 * link 2 is for maxProduct1() mehtod this is modified Kadace algorithm
 */

public class MaximumProductSubarray {
    public static void main(String args[]){
        int arr[]={6,-3,-10,0,2};
        MaximumProductSubarray mps=new MaximumProductSubarray();
        // System.out.println(mps.maxProduct(arr,arr.length));
        System.out.println(mps.maxProduct1(arr, arr.length));
    }

    long maxProduct1(int[] arr, int n) {
        // code here
        long maxProduct=Integer.MIN_VALUE;
        long minProduct=Integer.MAX_VALUE;
        long ans=Integer.MIN_VALUE;
        long temp;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                temp=maxProduct;
                maxProduct=minProduct;
                minProduct=temp;
            }
            
            maxProduct=Math.max(arr[i],(maxProduct*arr[i]));
            minProduct=Math.min(arr[i],(minProduct*arr[i]));
            ans=Math.max(ans,Math.max(maxProduct,minProduct));
        }
        
        return ans;
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
