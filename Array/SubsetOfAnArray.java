/*
 * Question link - https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1
 * Explanation video link - https://www.youtube.com/watch?v=Xe9HjetqUBs&ab_channel=Yogesh%26Shailesh%28CodeLibrary%29
 */

import java.util.HashMap;

public class SubsetOfAnArray{
    public static void main(String args[]){
        long a1[]={11, 7, 1, 13, 21, 3, 7, 3};
        long a2[]={11, 3, 7, 1, 7};

        System.out.println(isSubset(a1, a2, a1.length, a2.length));
    }

    public static String isSubset( long a1[], long a2[], long n, long m) {
        int count=0;
        
        HashMap<Long, Integer> map=new HashMap<Long,Integer>();
        for(int i=0;i<a2.length;i++){
            map.put(a2[i], map.getOrDefault(a2[i],0)+1);
        }
        
        for(int i=0;i<a1.length;i++){
            if(map.getOrDefault(a1[i],0)>0){
                map.put(a1[i],map.get(a1[i])-1);
                count++;
            }
        }
        
        return count==a2.length ? "Yes" : "No";
        
    }
}