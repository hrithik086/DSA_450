import java.util.Arrays;

/*
 *  question link - https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 * 
 * we need to solve this without using any sorting algorithms and we need to inplace sorting 
 * i have used an approach in which i am traversing the array if 0 comes i am swaping it with left side of the array and if
 * 2 comes i am swaping it with right side of the array
 */

public class ArraysOf0s1sAnd2s {
    public static void main(String args[]){
        int arr[]={0,2,1,2,0};
        sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort012(int a[], int n)
    {
        int index0=-1;
        int index2=a.length;
        
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                index0++;
                swap(a,i,index0);
            }
            if(a[i]==2 && i< index2){
                index2--;
                swap(a,i,index2);
                i--;
            }
        }
        
    }

    public static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
