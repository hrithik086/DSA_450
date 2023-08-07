/*
 * Question link -https://practice.geeksforgeeks.org/problems/sorted-matrix2333/1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortedMatrix {
    public static void main(String args[]){
        // int Mat[][]={{10,20,30,40},
        //                 {15,25,35,45}, 
        //                 {27,29,37,48}, 
        //                 {32,33,39,50}};

        int Mat[][]={
            {1,5,3},
            {2,8,7},
            {4,6,9}
        };

        SortedMatrix sm=new SortedMatrix();
        int arr[][]=sm.sortedMatrix(Mat.length, Mat);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    int[][] sortedMatrix(int N, int Mat[][]) {
        // code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        int pointer=0;
        
        for(int i=0;i<Mat.length;i++){
            for(int j=0;j<Mat[0].length;j++){
                list.add(Mat[i][j]);
            }
        }
        
        Collections.sort(list);
        for(int i=0;i<Mat.length;i++){
            for(int j=0;j<Mat[0].length;j++){
                Mat[i][j]=list.get(pointer);
                pointer++;
            }
        }
        
        return Mat;
        
    }
}
