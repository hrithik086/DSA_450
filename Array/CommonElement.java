/*
 * Question link - https://practice.geeksforgeeks.org/problems/common-elements1132/1
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonElement {
    public static void main(String args[]){
        int A[] = {1, 5, 10, 20, 40, 80};
        int B[]= {6, 7, 20, 80, 100};
        int C[]= {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(commonIntegers(A, B, C));
    }

    public static ArrayList<Integer> commonIntegers(int A[], int B[], int C[]){
        //map which will store the occurance of particular integer in it
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        ArrayList<Integer> commonList=new ArrayList<Integer>();
        
        //loop for array A
        map.put(A[0],1);
        for(int i=1;i<A.length;i++){
            if(A[i]!=A[i-1]){
                map.put(A[i],map.getOrDefault(A[i],0)+1);
            }
        }
        
        //loop for array B
        map.put(B[0], map.getOrDefault(B[0],0)+1);
        for(int i=1;i<B.length;i++){
            if(B[i]!=B[i-1]){
                map.put(B[i],map.getOrDefault(B[i],0)+1);
            }
        }
        
        //loop for array C
        map.put(C[0],map.getOrDefault(C[0],0)+1);
        for(int i=1;i<C.length;i++){
            if(C[i]!=C[i-1]){
                map.put(C[i],map.getOrDefault(C[i],0)+1);
                if(map.get(C[i])==3){
                    commonList.add(C[i]);
                }
            }
        }
        
        return commonList;
    }
}
