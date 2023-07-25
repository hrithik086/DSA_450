/*
 * Question Link - https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 * Explanation Video Link - https://www.youtube.com/watch?v=50nn3bA1BT4&ab_channel=Pepcoding
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChocolateDistributionProblem {
    public static void main(String args[]){
        ChocolateDistributionProblem cdp=new ChocolateDistributionProblem();
        // int arr[]={3, 4, 1, 9, 56, 7, 9, 12};
        // int m=5;
        int arr[]={7, 3, 2, 4, 9, 12, 56};
        int m=3;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++)
            list.add(arr[i]);

        System.out.println(cdp.findMinDiff(list, list.size(), m));
    }

    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long minDiff=Integer.MAX_VALUE;
        
        for(int i=0;i<=a.size()-m;i++){
            minDiff=Math.min(minDiff, (a.get(i+m-1)-a.get(i)));
        }
        
        return minDiff;
    }
}
