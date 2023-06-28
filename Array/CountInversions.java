/*
 * question link - https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * explanation video link - https://www.youtube.com/watch?v=tgl2fWHUCcI&t=1s&ab_channel=CodewithAlisha
 */

import java.util.Arrays;

public class CountInversions{
    public static void main(String args[]){
        long arr[]={2, 4, 1, 3, 5};
        // long arr[]={2, 3, 4, 5, 6};
        System.out.println(inversionCount(arr, arr.length));
    }

    static long inversionCount(long arr[], long N)
    {
        mergeSort(arr,0,arr.length-1);
        return numberOfInversions;
    }
    
    static long numberOfInversions=0l;
    

    //divide the array into half half of sorted array and then merge the arrays
    static void mergeSort(long arr[],int start, int end){
        if(start < end){
            int mid=(start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    
    //merge two sorted array as a single array
    static void merge(long arr[], int start, int mid, int end){
        long arr1[]=Arrays.copyOfRange(arr,start,mid+1);
        long arr2[]=Arrays.copyOfRange(arr,mid+1,end+1);
        
        int arr1Pointer=0;
        int arr2Pointer=0;
        int i;
        
        for(i=start;i<=end && arr1Pointer<arr1.length && arr2Pointer<arr2.length;i++){

            //as this is merge operation we can concider arr1 and arr2 are sorted in ascending order
            //if an element from starting of arr2 is less than an element from the starting of arr1
            //this means smallest element of arr2 is less than smallest element of arr1
            //the value at arr2[arr2Pointer] will create inversion with all the values of arr1[arr1Pointer] to arr1[arr1.length-1]
            if(arr2[arr2Pointer]<arr1[arr1Pointer]){
                numberOfInversions+=arr1.length-arr1Pointer;
                arr[i]=arr2[arr2Pointer];
                arr2Pointer++;
            }
            
            else if(arr1[arr1Pointer]<arr2[arr2Pointer]){
                arr[i]=arr1[arr1Pointer];
                arr1Pointer++;
            }
            
            else{
                arr[i]=arr1[arr1Pointer];
                arr1Pointer++;
            }
        }
        
        while(i<=end && arr1Pointer<arr1.length){
            arr[i]=arr1[arr1Pointer];
            i++;
            arr1Pointer++;
        }
        
        while(i<=end && arr2Pointer<arr2.length){
            arr[i]=arr2[arr2Pointer];
            arr2Pointer++;
            i++;
        }
        
        
        
    }
}