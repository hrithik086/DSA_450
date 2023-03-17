import java.util.Arrays;

/*
 * question link - https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
 * 
 * explanation video link - https://www.youtube.com/watch?v=ZScoWGnvcv0
 *                          https://www.youtube.com/watch?v=ZScoWGnvcv0
 */

public class MinimumHeight {
    public static void main(String args[]){
        int arr[]={1,9, 10, 1, 1, 3, 10, 3, 4, 6};
        int k=4;
        System.out.println(getMinDiff(arr, k));
    }

    static int getMinDiff(int arr[],int k){
        Arrays.sort(arr);
        int smallest=arr[0]+k;
        int largest=arr[arr.length-1]-k;
        // int diff=0;
        int ans=arr[arr.length-1]-arr[0];
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

        for(int i=0;i<arr.length-1;i++){
            min=Math.min(smallest, arr[i+1]-k);
            max=Math.max(largest, arr[i]+k);
            if(min<0){
                continue;
            }
            ans=Math.min(ans, max-min);
        }

        return ans;
    }
}
