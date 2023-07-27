/*
 * question link - https://practice.geeksforgeeks.org/problems/three-way-partitioning/1
 * Explanation Video link - https://www.youtube.com/watch?v=ptIRm-GTUdw&ab_channel=Yogesh%26Shailesh%28CodeLibrary%29
 * Explanation Video Link - https://www.youtube.com/watch?v=ihNJWLadLHI&ab_channel=AyushiSharma
 */

import java.util.Arrays;

public class ThreeWayPartition {
    public static void main(String args[]){
        // int arr[]={76 ,8 ,75 ,22 ,59 ,96 ,30 ,38 ,36};
        // int a=44;
        // int b=62;
        int arr[]={44 ,12 ,29 ,30 ,77 ,5 ,44 ,64 ,14};
        int a=39;
        int b=45;
        threeWayPartition(arr, a, b);
        System.out.println(Arrays.toString(arr));
    }

    public static void threeWayPartition(int array[], int a, int b)
    {
        // code here 
        int left=0;
        int right=array.length-1;
        int temp;
        
        for(int i=0;i<array.length &&  i<=right;i++){
            if(array[i]>a && array[i]>b){
                //swap array of i with array of right and decrease right
                temp=array[right];
                array[right]=array[i];
                array[i]=temp;
                right--;
                i--;
            }
            
            else if(array[i]<a){
                //swap the array with the left one and increase the left
                temp=array[left];
                array[left]=array[i];
                array[i]=temp;
                left++;
            }
        }
    }
}
