/*
 * Question name- Kth Smallest Element
 * Geeks for Geeks link - https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
 * 
 * we can implement this by using QuickSelect algorithim which is similar to quicksort algorithm
 * 
 * i tried this same question in leetcode but there normal java sorting was giving less time complexity than the quickSelect algorithm.
 * QuickSelect algorithm explanation link - https://www.youtube.com/watch?v=XEmy13g1Qxc&t=520s
 */

import java.util.*;

public class KthSmallestElement{
    public static void main(String args[]){
        int arr[]={7,10,4,3,20,15};
        // System.out.println(kthSmallest(arr,0,arr.length,3));
        System.out.println(quickSelect(arr,3));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        return arr[k-1];
    } 

    public static int quickSelect(int arr[], int k){
        int l=0;
        int r=arr.length-1;
        int pivot=r;
        int index=l-1;
        do{
            // System.out.println(Arrays.toString(arr));
            index=l-1;
            pivot=r;
            // System.out.println("pivot = "+arr[pivot]);
            // System.out.println("left = "+l);
            // System.out.println("right ="+r);
            for(int i=l;i<=r;i++){
                if(arr[i]<arr[pivot]){
                    index++;
                    swap(arr, index, i);
                }
            }
            index++;
            swap(arr,index,pivot);
            if((k-1)>index){
                l=index+1;
            }
            else if((k-1)<index){
                r=index-1;
            }

        }while(index!=(k-1));
        return arr[index];
    }

    public static void swap(int arr[],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
