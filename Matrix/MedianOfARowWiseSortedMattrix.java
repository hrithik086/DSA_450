/*
 * Question link - https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
 * Explanation video link - https://www.youtube.com/watch?v=aNIfGl1ZKQE&t=955s&ab_channel=ShashwatTiwari
 * Explanation Article - https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
 * 
 * i have followed the Explanation Article code.
 */

import java.util.Arrays;

public class MedianOfARowWiseSortedMattrix {
    public static void main(String args[]){
        // int arr[][]={{1, 3, 5}, 
        //             {2, 6, 9}, 
        //             {3, 6, 9}};
        // int R=3;
        // int C=3;

        int arr[][]={
            {1},
            {2},
            {3}
        };
        int R=3;
        int C=1;

        MedianOfARowWiseSortedMattrix mat=new MedianOfARowWiseSortedMattrix();
        System.out.println(mat.median(arr, R, C));
    }

    int median(int matrix[][], int R, int C) {
        // code here  
        int desired=(R*C+1)/2;
        int min=1;
        int max=2000;
        int mid=0;
        int arr[];
        int get=0;
        int elementsLessThanMid=0;
        
        while(min < max){
            mid=(max+min)/2;
            elementsLessThanMid=0;
            for(int i=0;i<R;i++){
                arr=matrix[i];
                get=Arrays.binarySearch(arr,mid);
                
                if(get<0){
                    get=Math.abs(get)-1;
                }
                else{
                    while(get<C && arr[get] == mid){
                        get++;
                    }
                }
                
                elementsLessThanMid+=get;
            }
            
            if(elementsLessThanMid < desired){
                min=mid+1;
            }
            else{
                max=mid;
            }
        }
        
        return min;
        
    }
}
