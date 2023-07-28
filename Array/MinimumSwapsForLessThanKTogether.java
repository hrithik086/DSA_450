/*
 * Question Link - https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1
 * Explanation Video Link - https://www.youtube.com/watch?v=yXjVfeWzyAM&ab_channel=AyushiSharma
 */

public class MinimumSwapsForLessThanKTogether {
    public static void main(String args[]){
        // int arr[]=  {2, 1, 5, 6, 3};
        // int k=3;
        int arr[]= {2, 7, 9, 5, 8, 7, 4};
        int k=6;
        System.out.println(minSwap(arr, arr.length, k));
    }

    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        int elementsLessThanK=0;
        int lesserThanK=0;
        int greaterThanK=0;
        int swap=0;
        int minSwap=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k){
                elementsLessThanK++;
            }
        }
        
        for(int i=0;i<elementsLessThanK;i++){
           if(arr[i]<=k){
               lesserThanK++;
           } 
           else{
               greaterThanK++;
           }
        }
        swap=greaterThanK;
        
        for(int i=1,j=elementsLessThanK;j<arr.length;i++,j++){
            if(arr[i-1]<=k){
                lesserThanK--;
            }
            else{
                greaterThanK--;
            }
            
            if(arr[j]<=k){
                lesserThanK++;
            }
            else{
                greaterThanK++;
            }
            
            swap=Math.min(swap,greaterThanK);
        }
        
        return swap;
    }
}
