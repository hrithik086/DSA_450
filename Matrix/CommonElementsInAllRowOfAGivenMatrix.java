/*
 * question link - https://www.geeksforgeeks.org/common-elements-in-all-rows-of-a-given-matrix/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CommonElementsInAllRowOfAGivenMatrix {
    public static void main(String args[]){
        int mat[][]={{1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                    };
        System.out.println(commonElements(mat));
    }

    public static List<Integer> commonElements(int mat[][]){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> tempSet;

        for(int i=1;i<mat[0].length;i++){
            set.add(mat[0][i]);
        }

        for(int i=1;i<mat.length;i++){
            tempSet=new HashSet<>();
            for(int j=0;j<mat[i].length;j++){
                if(set.contains(mat[i][j])){
                    tempSet.add(mat[i][j]);
                }
            }
            set=tempSet;
        }

        return new ArrayList<>(set);
    }
}
