/*
 * Question link - https://www.geeksforgeeks.org/find-a-specific-pair-in-matrix/
 * Explanation Video link1 - https://www.youtube.com/watch?v=nK1HtsulAvc&ab_channel=BinaryBuddies
 * Explanation Video link2 - https://www.youtube.com/watch?v=aUhR_T5J9is&ab_channel=NULL 
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class SpecificPairInMatrix {
    public static void main(String args[]){
        int mat[][] = {{ 1, 2, -1, -4, -20 },
                        { -8, -3, 4, 2, 1 }, 
                        { 3, 8, 6, 1, 3 },
                        { -4, -1, 1, 7, -6 },
                        { 0, -4, 10, -5, 1 }
                    };

        System.out.println(maxDiff(mat));
    }

    //this is my approach
    public static int findMaxDiff(int mat[][]){
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        int max =  Integer.MIN_VALUE;
        ArrayList<Integer> tempList = null;
        int c,d;

        //iterate from bottom right corner to to top left corner in the mattrix
        //and put the element in the treeMap as key and the index of the element as the value in treeMap
        for(int a=mat.length-1; a>=0; a--){
            for(int b=mat.length-1; b>=0; b--){

                //iterate the treeMap and check is there any element which is greater then the current element
                for(Map.Entry<Integer, ArrayList<Integer>> entry : treeMap.entrySet()){
                    if(entry.getKey() > mat[a][b]){
                        tempList = entry.getValue();

                        //if you found an element which is greater than the currrent element in the treeMap
                        //check from the value that the index values are greter then the index of current element
                        for(int k=0; k < tempList.size(); k+=2){
                            c=tempList.get(k);
                            d=tempList.get(k+1);
                            if(c > a && d > b){
                                max = Math.max(max, mat[c][d] - mat[a][b]);
                                break;
                            }
                        }
                    }
                    else if(entry.getKey() < mat[a][b]){
                        break;
                    }
                }

                //add the current element in the treeMap
                //if the key is already present just append the new indexes to the existing ArrayList of the element
                //if the key is not present create a new empty arryalist and add the index of the element.
                if(!treeMap.containsKey(mat[a][b])){
                    treeMap.put(mat[a][b], new ArrayList<Integer>());
                }
                treeMap.get(mat[a][b]).add(a);
                treeMap.get(mat[a][b]).add(b);
            }
        }
        

        return max;
    }

    //optimized approach
    public static int maxDiff(int mat[][]){
        //this will store the max element in a sub square matrix
        int preComputeMat[][] = new int[mat.length][mat[0].length];
        int max = Integer.MIN_VALUE;
        int right, bottom, diagonal;

        for(int i=mat.length-1; i>0; i--){
            for(int j=mat[0].length-1; j>0; j--){
                //calculate the highest element in the submatrix
                //compare the the present element from max element of right SubSquareMatrix, bottom SubSquareMatix and DiagonalSubSquareMatrix
                right = j < mat[0].length-1 ? preComputeMat[i][j+1] : Integer.MIN_VALUE;
                bottom = i < mat.length-1 ? preComputeMat[i+1][j] : Integer.MIN_VALUE;
                diagonal = j < mat[0].length-1 && i < mat.length-1 ? preComputeMat[i+1][j+1] : Integer.MIN_VALUE; 
                preComputeMat[i][j] = Math.max(mat[i][j], Math.max(right, Math.max(bottom, diagonal)));

                //the element at i,j position of preComputeMat is the highest element from sub square matrix for the 
                //element present in the i-1,j-1 position of mat
                //we can subtract and check the max difference
                max = Math.max(max, preComputeMat[i][j]-mat[i-1][j-1]);
            }
        }

        return max;
    }
}
