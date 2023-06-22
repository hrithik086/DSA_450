/*
 * question link - https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
 * Explanation video - https://www.youtube.com/watch?v=mF3ofENSeg8&ab_channel=PrakashShukla
 */

import java.util.Arrays;

public class MergeSortedArraysWithoutUsingThirdArray {
    public static void main(String args[]){
        long arr1[]={1,3,5,7};
        long arr2[]={0,2,6,8,9};
        merge(arr1,arr2,arr1.length,arr2.length);
        System.out.println(Arrays.toString(arr1)+Arrays.toString(arr2));
    }

    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        
        //looping with the size of first array
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]>arr2[0]){
                //values are interchanged
                swapValuesInArray(arr1,arr2,i);
                
                //sort the values in arr1 in proper format
                sortArr(arr1,i);
                
                //soft the values in arr2 in proper format
                sortArr(arr2,0);
            }
        }   
        
        // int arr[]={5,1,2,3,4};
        // sortArr(arr,0);
        // System.out.println(Arrays.toString(arr));
        
        
        
    }

    //Function to swap values from two array 
    public static void swapValuesInArray(long arr1[], long arr2[], int index){
        arr1[index]+=arr2[0];
        arr2[0]=arr1[index]-arr2[0];
        arr1[index]-=arr2[0];
    }

    //Function to sort the array again in proper format
    public static void sortArr(long arr[], int index){
        if((index>0 && arr[index-1]<=arr[index]) && (index < arr.length-1 && arr[index+1]>=arr[index])){
            return;
        }
        
        else if(index>0 && arr[index-1]>arr[index]){
            int i=index;
            long temp=arr[index];
            while(i>0 && arr[i-1]>temp){
                arr[i]=arr[i-1];
                i--;
            }
            arr[i]=temp;
        }
        
        else{
            int i=index;
            long temp=arr[index];
            while(i<arr.length-1 && arr[i+1]<temp){
                arr[i]=arr[i+1];
                i++;
            }
            arr[i]=temp;
        }
    }
}
