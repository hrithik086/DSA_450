/*
 * Question link - https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 */

import java.util.Arrays;

public class RearrangeArray {
    public static void main(String args[]){
        // int arr[]={-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int arr[]={1, 2, 3, -4, -1, 4};
        arr=rearrangeArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] rearrangeArray(int arr[]){
        int j;
        int temp;

        for(int i=0;i<arr.length;i++){
            //odd index should have negative value
            if(i%2==0){
                if(arr[i]>0){
                    j=i+1;
                    //find the index having negative value
                    while(j<arr.length && arr[j]>=0){
                        j++;
                    }
                    if(j==arr.length){
                        break;
                    }
                    else{
                        //shift the values
                        temp=arr[j];
                        while(j>i){
                            arr[j]=arr[j-1];
                            j--;
                        }
                        arr[j]=temp;
                    }
                }
            }
            //even index should have positive value
            else{
                if(arr[i]<0){
                    j=i+1;
                    //search for an positive value
                    while(j<arr.length && arr[j]<0){
                        j++;
                    }
                    if(j==arr.length){
                        break;
                    }
                    else{
                        //shift values
                        temp=arr[j];
                        while(j>i){
                            arr[j]=arr[j-1];
                            j--;
                        }
                        arr[j]=temp;
                    }
                }
            }
        }

        return arr;
    }
}
