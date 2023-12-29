/*
 * Question link - https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class KthSmallestElement {
    public static void main(String args[]){
        int mat[][] = {{16, 28, 60, 64},
                        {22, 41, 63, 91},
                        {27, 50, 87, 93},
                        {36, 78, 87, 94 }
                    };
        // System.out.println(kthSmallest(mat, mat.length, 3));
        System.out.println(kthSmallestElement(mat, 3));

    }


    public static int kthSmallestElement(int mat[][], int k){
        ArrayList<Integer> minHeap = new ArrayList<Integer>();
        int kthMinElement = 0;
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                minHeap.add(mat[i][j]);
                buildMinHeap(minHeap);
            }
        }

        for(int i=0; i<k;i++){
            kthMinElement = getMinElement(minHeap);
        }

        return kthMinElement;
    }

    public static void buildMinHeap(ArrayList<Integer> list){

        if(list.size()==0){
            return;
        }

        int currentIndex = list.size()-1;
        int parentIndex = parentIndex(currentIndex);
        int currentNodeValue = list.get(currentIndex);

        while(parentIndex>=0 && list.get(parentIndex)>currentNodeValue){
            swap(list, currentIndex, parentIndex);
            currentIndex=parentIndex;
            parentIndex=parentIndex(currentIndex);
        }
    }

    public static int getMinElement(ArrayList<Integer> list){
        if(list.size()==0){
            return Integer.MAX_VALUE;
        }

        int min=list.get(0);
        list.set(0, list.get(list.size()-1));
        list.remove(list.size()-1);
        if(list.size()>0){
            heapify(list, 0);
        }

        return min;
    }

    public static void heapify(ArrayList<Integer> list, int index){
        int parentIndex = index;
        int leftChildIndex;
        int rightChildIndex;

        int parent;
        int leftChild;
        int rightChild;
        
        while(parentIndex<list.size()){
            parent=list.get(parentIndex);
            leftChildIndex = leftChildIndex(parentIndex);
            rightChildIndex = rightChildIndex(parentIndex);

            if(leftChildIndex < list.size() && rightChildIndex < list.size()){
                leftChild = list.get(leftChildIndex);
                rightChild = list.get(rightChildIndex);

                if(leftChild <= rightChild){
                    if(leftChild < parent){
                        swap(list, leftChildIndex, parentIndex);
                        parentIndex = leftChildIndex;
                    }
                    else{
                        break;
                    }
                }
                else{
                    if(rightChild < parent){
                        swap(list, rightChildIndex, parentIndex);
                        parentIndex = rightChildIndex;
                    }
                    else{
                        break;
                    }
                }
            }
            else if(leftChildIndex < list.size() && rightChildIndex == list.size()){
                leftChild=list.get(leftChildIndex);
                if(leftChild < parent){
                    swap(list, leftChildIndex, parentIndex);
                    parentIndex = leftChildIndex;
                }
            }
            else{
                break;
            }
        }
    }

    public static int parentIndex(int childIndex){
        int parent;
        if(childIndex%2 == 0){
            parent = childIndex/2 -1;
        }
        else{
            parent = childIndex/2;
        }

        return parent;
    }

    public static int leftChildIndex(int parentIndex){
        return (2*parentIndex)+1;
    }

    public static int rightChildIndex(int parentIndex){
        return (2*parentIndex)+2;
    }

    public static void swap(ArrayList<Integer> list, int index1, int index2){
        list.set(index1, list.get(index1)+list.get(index2));
        list.set(index2, list.get(index1)-list.get(index2));
        list.set(index1, list.get(index1)-list.get(index2));
    }



    //-------------------------------------------------------------------------------------------------------
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
