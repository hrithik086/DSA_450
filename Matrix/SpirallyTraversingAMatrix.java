/*
 * Question link - https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 */

import java.util.ArrayList;

public class SpirallyTraversingAMatrix{
    public static void main(String args[]){
        // int arr[][]={
        //     {6,6,2,28,2},
        //     {12,26,3,28,7},
        //     {22,25,3,4,23}
        // };
        // int r=3;
        // int c=4;

        // int arr[][]={
        //     {1,2,3,4},
        //     {5,6,7,8},
        //     {9,10,11,12}
        // };
        // int r=3;
        // int c=4;

        int arr[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int r=4;
        int c=4;



        System.out.println(spirallyTraverse(arr,r,c));
    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> list=new ArrayList<Integer>();
        boolean up=false;
        boolean down=false;
        boolean right=true;
        boolean left=false;
        int i=0;
        int j=0;
        
        while(up || down || right || left){
            if(right){
                for(;j<c && matrix[i][j]!=-1;j++){
                    list.add(matrix[i][j]);
                    matrix[i][j]=-1;
                    // System.out.println(list);
                }
                j--;
                if((i+1)<r && j<c && i>=0 && j>=0 && matrix[i+1][j]!=-1){
                    i++;
                    down=true;
                }
                right=false;
                
            }
            
            else if(down){
                for(;i<r && matrix[i][j]!=-1;i++){
                    list.add(matrix[i][j]);
                    matrix[i][j]=-1;
                    // System.out.println(list);
                }
                i--;
                if(j-1>=0 && i>0 && j<c && i<r && matrix[i][j-1]!=-1){
                    j--;
                    left=true;
                }
                down=false;
            }
            
            else if(left){
                for(;j>=0 && matrix[i][j]!=-1;j--){
                    list.add(matrix[i][j]);
                    matrix[i][j]=-1;
                }
                j++;
                if(i-1 >=0 && j>=0 && i<r && j<c && matrix[i-1][j]!=-1){
                    i--;
                    up=true;
                }
                left=false;
            }
            
            else if(up){
                for(; i>=0 && matrix[i][j]!=-1 ; i--){
                    list.add(matrix[i][j]);
                    matrix[i][j]=-1;
                }
                i++;
                if(j+1< c && i<c && i>=0 && j>=0  && matrix[i][j+1]!=-1){
                    j++;
                    right=true;
                }
                up=false;
            }
            // System.out.println(list);
        }
    

        return list;
    }
}