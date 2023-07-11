/*
 * Question link - https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
 * Explanation video link - https://www.youtube.com/watch?v=8inhayLCCHs&ab_channel=HelloWorld
 * little bit advance question of this question is - Subarray with Sum K which has been done in the previous commit of this commit
 */

import java.util.HashSet;
import java.util.Set;

public class SubarrayWith0Sum {
    public static void main(String args[]){
        // int arr[]={4,2,-3,1,6};
        int arr[]={4,2,0,1,6};
        System.out.println(findsum(arr,arr.length));
    }

    static boolean findsum(int arr[],int n)
    {
        
        //set to store the prefix sum 
        Set<Integer> set=new HashSet<Integer>();
        
        //variable to store the prefix sum
        int sum=0;
        
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            if(sum==0){
                return true;
            }
            else if(set.contains(sum)){
                return true;
            }
            
            set.add(sum);
        }
        
        return false;
           
    }
}
