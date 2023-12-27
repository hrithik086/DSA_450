/*
 * Question link - https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class KthSmallestElement {
    public static void main(String args[]){
        // int arr[] = {8,3,4,2,0,0,3,9,0,9};
        // // int arr[] = {2};
        // LinkedList<Integer> linkedList = new LinkedList<Integer>();
        // int i=0;
        
        // for(int item : arr){
        //     if(i<5){
        //         binarySearchAndAdd(linkedList, item, true);
        //         i++;
        //     }
        //     else{
        //         binarySearchAndAdd(linkedList, item, false);
        //     }
        // }

        // // System.out.println(binarySearch(linkedList, 3));
        // System.out.println(linkedList);

        int mat[][] = {{16, 28, 60, 64},
                        {22, 41, 63, 91},
                        {27, 50, 87, 93},
                        {36, 78, 87, 94 }
                    };
        System.out.println(kthSmallest(mat, mat.length, 3));

    }

    //this is my approach we can still optimize this
    public static int kthSmallest(int[][]mat,int n,int k)
	{
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int counter=0;
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                
                if(counter<k){
                    binarySearchAndAdd(linkedList, mat[i][j], true);
                    counter++;
                }
                else{
                    binarySearchAndAdd(linkedList, mat[i][j], false);
                }
                
            }
        }

        return linkedList.get(linkedList.size()-1);
    }

    public static int binarySearchAndAdd(LinkedList<Integer> linkedList, int item, boolean expand){
        int insertIndex = binarySearch(linkedList, item);

        if(expand){
            if(insertIndex == linkedList.size()){
                linkedList.add(item);
            }
            else{
                linkedList.add(insertIndex, item);
            }
        }
        else{
            linkedList.add(insertIndex, item);
            linkedList.removeLast();
        }
        
        return 0;
    }
    
    public static int binarySearch(LinkedList<Integer> linkedList, int item){
        int start=0;
        int end=linkedList.size()-1;
        int mid=0;

        if(linkedList.size()!=0){
            while(start<end){
                mid=(start+end)/2;
                if(linkedList.get(mid)==item){
                    return mid;
                }
                else if(linkedList.get(mid)<item){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }

            if(start==end){
                if(linkedList.get(start)==item){
                    return start;
                }
                return linkedList.get(start) > item ? start : start+1;
            }
            else if(start != end){
                if(start>=0 && start<linkedList.size() && linkedList.get(start) >= item){
                    return start;
                }
                else if(end>=0 && end<linkedList.size() && linkedList.get(end) >= item){
                    return end;
                }
            }

            return -1;
        }
        else{
            return 0;
        } 
    }
}
