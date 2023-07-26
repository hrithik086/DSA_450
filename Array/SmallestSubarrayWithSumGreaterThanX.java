/*
 * Question Link - https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
 * Explanation Video Link - https://www.youtube.com/watch?v=21tQXPbGg7k&ab_channel=Yogesh%26Shailesh%28CodeLibrary%29
 */

public class SmallestSubarrayWithSumGreaterThanX {
    public static void main(String args[]){
        // int arr[]={1, 4, 45, 6, 0, 19};
        // int x=51;
        int arr[]={1, 10, 5, 2, 7};
        int x=9;
        System.out.println(smallestSubWithSum(arr, arr.length, x));
    }

    public static int smallestSubWithSum(int a[], int n, int x) {
        
        int start=0;
        int end=0;
        int sum=a[end];
        int min=Integer.MAX_VALUE;
        
        
        while(end<a.length && start<=end){
            if(sum>x){
                min=Math.min(min,((end-start)+1));
                sum-=a[start];
                start++;
            }
            else{
                end++;
                
                if(end<a.length){
                    sum+=a[end];
                    min=sum>x ? Math.min(min,((end-start)+1)) : min;
                }
            }
        }
        
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
