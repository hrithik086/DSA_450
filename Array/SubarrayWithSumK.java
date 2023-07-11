/*
 * Question link - https://leetcode.com/problems/subarray-sum-equals-k/description/
 * Explanation Video1 link - https://www.youtube.com/watch?v=8inhayLCCHs&ab_channel=HelloWorld
 * Explanation Video2 link - https://www.youtube.com/watch?v=r1cwGocurtA&ab_channel=CodewithAlisha
 */

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithSumK {
    public static void main(String args[]){
        int nums[]={1,2,3,4,-10,0,5};
        int k=5;
        SubarrayWithSumK s=new SubarrayWithSumK();
        System.out.println(s.subarraySum(nums,k));
    }   
    
    public int subarraySum(int[] nums, int k) {
        //Hash map to store the number of occurence prefix sum 
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        int sum=0;
        int count=0;
        int temp;
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            temp=sum-k;
            if(map.containsKey(temp)){
                count+=map.get(temp);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }


        return count;
    }
}
