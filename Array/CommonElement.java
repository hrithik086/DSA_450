/*
 * Question link - https://practice.geeksforgeeks.org/problems/common-elements1132/1
 * Explanation video link - https://www.youtube.com/watch?v=ajWCEu1razQ&ab_channel=Yogesh%26Shailesh%28CodeLibrary%29
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonElement {
    public static void main(String args[]){
        int A[] = {1, 5, 10, 20, 40, 80};
        int B[]= {6, 7, 20, 80, 100};
        int C[]= {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(commonElements(A, B, C, A.length, B.length, C.length));
    }

    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> commonList=new ArrayList<Integer>();
        int i=0, j=0, k=0;
        
        while(i<A.length && j<B.length && k<C.length){
            if(A[i]==B[j] && B[j]==C[k]){
                //this if block is for unique elements
                if(commonList.size()>0 && commonList.get(commonList.size()-1)==C[k]){
                    i++;
                    j++;
                    k++;
                    continue;
                }
                
                commonList.add(A[i]);
                i++;
                j++;
                k++;
            }
            
            else if(A[i]<B[j]){
                i++;
            }
            
            else if(B[j]<C[k]){
                j++;
            }
            
            else{
                k++;
            }
        }
        return commonList;
    }

    //my approach
    // public static ArrayList<Integer> commonIntegers(int A[], int B[], int C[]){
    //     //map which will store the occurance of particular integer in it
    //     Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    //     ArrayList<Integer> commonList=new ArrayList<Integer>();
        
    //     //loop for array A
    //     map.put(A[0],1);
    //     for(int i=1;i<A.length;i++){
    //         if(A[i]!=A[i-1]){
    //             map.put(A[i],map.getOrDefault(A[i],0)+1);
    //         }
    //     }
        
    //     //loop for array B
    //     map.put(B[0], map.getOrDefault(B[0],0)+1);
    //     for(int i=1;i<B.length;i++){
    //         if(B[i]!=B[i-1]){
    //             map.put(B[i],map.getOrDefault(B[i],0)+1);
    //         }
    //     }
        
    //     //loop for array C
    //     map.put(C[0],map.getOrDefault(C[0],0)+1);
    //     for(int i=1;i<C.length;i++){
    //         if(C[i]!=C[i-1]){
    //             map.put(C[i],map.getOrDefault(C[i],0)+1);
    //             if(map.get(C[i])==3){
    //                 commonList.add(C[i]);
    //             }
    //         }
    //     }
        
    //     return commonList;
    // }
}
