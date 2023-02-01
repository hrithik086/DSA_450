/*
 *  question link - https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
 * 
 *  i have used sets to solve this problem
 */

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArrays {
    public static void main(String args[]){
        int arr1[]={1,2,3,4,5};
        int arr2[]={1,2,3};
        System.out.println(doUnion(arr1,arr2));
    }

    public static int doUnion(int arr1[],int arr2[]){
        Set<Integer> set=new HashSet<Integer>();

        for(int num: arr1){
            set.add(num);
        }

        for(int num: arr2){
            set.add(num);
        }

        return set.size();
    }
}
