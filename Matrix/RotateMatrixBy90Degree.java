/*
 * Question link - https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
 */

import java.util.Arrays;

public class RotateMatrixBy90Degree {
    public static void main(String args[]){
        // int mat[][]={
        //     {1,2,3,4,5,6},
        //     {7,8,9,10,11,12},
        //     {13,14,15,16,17,18},
        //     {19,20,21,22,23,24},
        //     {25,26,27,28,29,30},
        //     {31,32,33,34,35,36}
        // };
        int mat[][]={
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };
        rotateBy90Degree(mat);
        Arrays.stream(mat).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    //my approach
    public static void rotateBy90Degree(int mat[][]){
        int right[] = new int[2];
        int bottom[] = new int[2];
        int left[] = new int[2];
        int top[] = new int[2];
        int temp1, temp2;
        
        //this is to iterate the from the outer border of matrix
        //to inner middle of the matrix
        for(int i=0;i<mat.length/2;i++){
            top[0]=i;
            top[1]=i;

            right[0]=i;
            right[1]=mat.length-1-i;

            bottom[0]=mat.length-1-i;
            bottom[1]=mat.length-1-i;

            left[0]=mat.length-1-i;
            left[1]=i;

            //this is to iterate the row and change values in the row
            for(int j=i; j<mat.length-1-i; j++){
                
                //pick an element from top row and place it in the perfect position in the right column
                temp1=mat[j][right[1]];
                mat[j][right[1]]=mat[i][j];

                //now you have picked the element from the right column in temp1 place it in the bottom row.
                temp2=mat[bottom[0]][mat.length-1-j];
                mat[bottom[0]][mat.length-1-j]=temp1;
                temp1=temp2;

                //now you have picke the element from bottom row in temp1 place it in the left column.
                temp2=mat[mat.length-1-j][left[1]];
                mat[mat.length-1-j][left[1]]=temp1;
                temp1=temp2;

                //now you have picked the element from left column place it in the top row.
                mat[i][j]=temp1;
            }
        }
    }
}
