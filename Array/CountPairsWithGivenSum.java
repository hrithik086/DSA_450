/*
 * Question Link - https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
 * Explanation video link - https://www.youtube.com/watch?v=5L9Jrehvoew&ab_channel=Yogesh%26Shailesh%28CodeLibrary%29
 */

import java.util.HashMap;

public class CountPairsWithGivenSum {
    public static void main(String args[]){
        // int arr[]={1, 5, 7, 1};
        // int k=6;
        int arr[]={1, 1, 1, 1};
        int k=2;
        CountPairsWithGivenSum cpws=new CountPairsWithGivenSum();
        System.out.println(cpws.getPairsCount(arr, 4, k));
    }

    int getPairsCount(int[] arr, int n, int k) {
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int pairCount=0;
        int temp=0;
        
        map.put(k-arr[0],1);
        for(int i=1;i<arr.length;i++){
            temp=map.getOrDefault(arr[i],0);
            pairCount+=temp;
            map.put(k-arr[i],map.getOrDefault(k-arr[i],0)+1);
        }
        
        return pairCount;
    }
}
