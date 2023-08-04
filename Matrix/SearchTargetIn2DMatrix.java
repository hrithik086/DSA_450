/*
 * Question link - https://leetcode.com/problems/search-a-2d-matrix/description/
 */


public class SearchTargetIn2DMatrix {
    public static void main(String args[]){
        // int matrix[][]={
        //     {1,3,5,7},
        //     {10,11,16,20},
        //     {23,30,34,60}
        // };
        // int target=3;

        int matrix[][]={
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target= 13;

        SearchTargetIn2DMatrix sti2m=new SearchTargetIn2DMatrix();
        System.out.println(sti2m.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int collumns=matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            if(target>=matrix[i][0] && target<=matrix[i][collumns-1]){
                for(int j=0;j<collumns;j++){
                    if(matrix[i][j]==target){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}