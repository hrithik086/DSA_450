/*
 * Question link - https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 * explanatin video link - https://www.youtube.com/watch?v=pLzOp2_Y9Vk&t=493s&ab_channel=CodewithAlisha
 */

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {
    public static void main(String args[]){
        // int arr[] = {2,6,1,9,4,5,3};
        int arr[] = {1,9,3,10,4,20,2};
        System.out.println(findLongestConseqSubseq1(arr, arr.length));
        // System.out.println(findLongestConseqSubseq(arr,arr.length));
    }

    //this takes 0.65 seconds in geeks for geeks
    //see the explanation video for better explanation of this approach
    static int findLongestConseqSubseq1(int arr[], int N) 
	{
	   int count=0;
	   int temp1;
	   int maxCount=1;
	   boolean continuing=false;
	   
	   HashSet<Integer> set=new HashSet<Integer>();
	   
	   for(int i=0;i<arr.length;i++){
	       set.add(arr[i]);
	   }
	   
	   Iterator<Integer> itr=set.iterator();
	   
	   while(itr.hasNext()){
	       temp1=itr.next();
	       if(set.contains(temp1-1)){
	           continue;
	       }
	       else{
	           count=0;
	           while(set.contains(temp1)){
	               count++;
	               temp1++;
	           }
	           maxCount=Math.max(maxCount, count);
	       }
	   }
	   
	   return maxCount;
	}

    //this takes 0.84 seconds in Geeks for Geeks
    //this is my approach
    static int findLongestConseqSubseq(int arr[], int N)
	{
	   int count=0;
	   int temp1=Integer.MIN_VALUE,temp2;
	   int maxCount=1;
	   boolean continuing=false;
	   
	   TreeSet<Integer> set=new TreeSet<Integer>();
	   
	   for(int i=0;i<arr.length;i++){
	       set.add(arr[i]);
	   }
	   
	   Iterator<Integer> itr=set.iterator();
	   if(itr.hasNext()){
	       temp1=itr.next();
	   }
	   
	   while(itr.hasNext()){
	       temp2=itr.next();
	       
	       if(!continuing && temp1==temp2-1){
	           count=2;
	           maxCount=Math.max(maxCount,count);
	           continuing=true;
	       }
	       else if(continuing && temp1==temp2-1){
	           count++;
	           maxCount=Math.max(maxCount,count);
	       }
	       else{
	           continuing=false;
	       }
	       
	       temp1=temp2;
	   }
	   
	   return maxCount;
	}
}
