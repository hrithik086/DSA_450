/*
 * Question link - https://practice.geeksforgeeks.org/problems/count-element-occurences/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
 * Explanation video link - https://www.youtube.com/watch?v=tzhFg9Jv3yo&ab_channel=AyushiSharma
 */

import java.util.HashMap;
import java.util.Map;

public class CountMoreThanNOccurence {
    public static void main(String args[]){
        // int arr[] = {3,1,2,2,1,2,3,3};
        // int k=4;
        int arr[]={2,3,3,2};
        int k=3;
        CountMoreThanNOccurence cmo= new CountMoreThanNOccurence();
        System.out.println(cmo.countOccurence(arr, arr.length, k));
    }

    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,return the answer
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int max=n/k;
        int count=0;
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer> me: map.entrySet()){
            if(me.getValue()>max){
                count++;
            }
        }
        
        return count;
    }
}
