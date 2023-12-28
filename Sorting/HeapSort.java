/*
 * Explanation Video link - https://www.youtube.com/watch?v=HqPJF2L5h9U&ab_channel=AbdulBari
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {
    public static void main(String args[]){
        Integer arr[] = {8,3,4,2,0,0,3,9,0,9};
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.asList(arr).stream().forEach(item -> list.add(item));
        minHeapSort(list);
    }

    public static void minHeapSort(ArrayList<Integer> arr){
        //sets the arraylist to minheap
        for(int i=arr.size()-1; i>=0; i--){
            heapify(arr, i);
        }

        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        int size = arr.size();
        for(int i=0; i<size; i++){
            sortedList.add(delete(arr));
        }

        System.out.println(sortedList);
    }

    public static void heapify(ArrayList<Integer> arr, int position){
        int index=position;
        int leftChildIndex, leftChild;
        int rightChildIndex, rightChild;
        int minChildIndex;

        while(index<arr.size()){
            leftChildIndex = getLeftChild(index);
            rightChildIndex = getRightChild(index);

            if(leftChildIndex < arr.size() && rightChildIndex < arr.size()){
                leftChild = arr.get(leftChildIndex);
                rightChild = arr.get(rightChildIndex);
                minChildIndex = leftChild < rightChild ? leftChildIndex : rightChildIndex;

                if(arr.get(index) <= arr.get(minChildIndex)){
                    break;
                }
                else{
                    swap(arr, minChildIndex, index);
                    index=minChildIndex;
                }
            }
            else if(leftChildIndex < arr.size() && rightChildIndex >= arr.size()){
                leftChild = arr.get(leftChildIndex);

                if(leftChild < arr.get(index)){
                    swap(arr, leftChild, index);
                    index=leftChildIndex;
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
    }

    public static int delete(ArrayList<Integer> arr){
        if(arr.isEmpty()){
            return Integer.MAX_VALUE;
        }

        int item = arr.get(0);
        
        swap(arr,0,arr.size()-1);
        arr.remove(arr.size()-1);
        heapify(arr, 0);

        return item;
    }

    public static int getLeftChild(int parent){
        return (2*parent)+1;
    }

    public static int getRightChild(int parent){
        return (2*parent)+2;
    }

    public static void swap(ArrayList<Integer> arr, int position1, int position2){
        arr.set(position1, arr.get(position1)+arr.get(position2));
        arr.set(position2, arr.get(position1)-arr.get(position2));
        arr.set(position1, arr.get(position1)-arr.get(position2));
    }

}
