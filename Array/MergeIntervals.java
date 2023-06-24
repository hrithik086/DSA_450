/*
 * question link - https://leetcode.com/problems/merge-intervals/description/
 * Explanation video link - https://www.youtube.com/watch?v=g1zOrfmNzvk&t=356s&ab_channel=CodewithAlisha
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals{
    public static void main(String args[]){
        // int arr[][]={
        //     {1,3},
        //     {2,6},
        //     {8,10},
        //     {15,18}
        // };
        int arr[][]={
            {1,4},
            {4,5}
        };
        int mergeArr[][]=merge(arr);

        Arrays.asList(mergeArr).stream().forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public static int[][] merge(int[][] intervals) {
        
        
        List<int[]> intervalList=Arrays.asList(intervals);
        List<int[]> finalList=new ArrayList<int[]>();
        int finalArr[][];
        int array1[],array2[]; 

        //we need to sort the intervals firsts
        Comparator<int[]> c = (arr1, arr2) -> {
            if(arr1[0]<arr2[0]){
                return -1;
            }
            else if(arr1[0]>arr2[0]){
                return 1;
            }
            else{
                if(arr1[1]<arr2[1]){
                    return -1;
                }
                else if(arr1[1]>arr2[1]){
                    return 1;
                }
                else return 0;
            }
        };
        Collections.sort(intervalList,c);

        //iterate the interval and search for overlapping intervals
        finalList.add(intervalList.get(0));
        for(int i=0;i<intervalList.size();i++){
            array1=intervalList.get(i);
            array2=finalList.get(finalList.size()-1);

            //if start interval of array1 comes before array2 start interval
            //as all are sorted according to start time and the smallest start interval is already in finalList
            //there is no way start interval of array 1 can come before start interval of array 2

            //if start interval of array2 comes before start interval of array1
            if((array1[0]>=array2[0] && array1[0]<=array2[1]) && array1[1]>=array2[1]){
                array2[1]=array1[1];
            }

            //if array1 is inside array2 i.e(if start interval of array 1 is greater than or equal to start interval of array 2
            //and end interval of array 1 is less than or equal to array2 end interval  )
            else if(array1[0]>=array2[0] && array1[1]<=array2[1]){
                continue;
            }

            else{
                finalList.add(array1);
            }
        }

        // finalList.stream().forEach(i -> System.out.println(Arrays.toString(i)));
        finalArr=new int[finalList.size()][2];
        for(int i=0;i<finalList.size();i++){
            finalArr[i]=finalList.get(i);
        }
        

        return finalArr;
    }
}