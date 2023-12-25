/*
 * Question link - https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
 * Explanation video link - https://www.youtube.com/watch?v=Z0R2u6gd3GU&ab_channel=takeUforward
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

        // rotateBy90Degree(mat);
        rotate90Degree(mat);

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

    //optimized approach
    //basic idea of this approach is transpose the matrix and then reverse rows or columns of the matrix based on the condition
    public static void rotate90Degree(int mat[][]){
        transposeMatrix(mat);
        //for clock wise 90 degree rotation after transpose reverse each row
        //for anti clock wise 90 degree rotation after transpose reverse each column
        reverseEachRowOfMatrix(mat);
        // reverseEachColumnOfMatrix(mat);
    }

    public static void transposeMatrix(int mat[][]){
        for(int i=0; i<mat.length; i++){
            for(int j=i+1; j<mat.length; j++){
                swap(mat,i,j,j,i);
            }
        }
    }

    public static void reverseEachRowOfMatrix(int mat[][]){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length/2; j++){
                swap(mat,i,j,i,mat.length-1-j);
            }
        }
    }

    public static void reverseEachColumnOfMatrix(int mat[][]){
        for(int j=0; j<mat.length; j++){
            for(int i=0; i<mat.length/2; i++){
                swap(mat, i, j, mat.length-1-i, j);
            }
        }
    }

    public static void swap(int mat[][], int i1, int j1, int i2, int j2){
        mat[i1][j1]+=mat[i2][j2];
        mat[i2][j2]=mat[i1][j1]-mat[i2][j2];
        mat[i1][j1]=mat[i1][j1]-mat[i2][j2];
    }
}
