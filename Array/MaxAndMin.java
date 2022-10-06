/**
 * Question link - https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 * find minimum and maximum number from the array
 */

public class MaxAndMin {
    public static void main(String args[]){
        int arr[]={22,14,8,17,35,3};
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<=arr.length/2;i++){
            if(i<(arr.length-i-2)){
                if(arr[i]<min){
                    min=arr[i];
                }
                if(arr[arr.length-1-i]<min){
                    min=arr[arr.length-1-i];
                }
                if(max<arr[i]){
                    max=arr[i];
                }
                if(max<arr[arr.length-1-i]){
                    max=arr[arr.length-1-i];
                }
            }
            else{
                if(arr[i]<min){
                    min=arr[i];
                }
                if(arr[i]>max){
                    max=arr[i];
                }
            }
        }

        System.out.println("minimum = "+min);
        System.out.println("maximum = "+max);
    }
}
