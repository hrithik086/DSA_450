/*
 * Question Link - https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
 * Explanation Link - https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
 * Explanation Video Link - https://www.youtube.com/watch?v=wiDLcGxhh80&ab_channel=DhruvGoyal
 */

public class MinimumNumberOfMergeToMakeArrayPallindrome {
    public static void main(String args[]){
        int arr[]={1, 4, 5, 1};
        System.out.println(minMergeForPallindrome(arr));
    }

    public static int minMergeForPallindrome(int arr[]){
        int left=0;
        int right=arr.length-1;
        int operation=0;

        while(left<=right){
            if(arr[left]==arr[right]){
                left++;
                right--;
            }
            else{
                if(arr[left]<arr[right]){
                    left++;
                    arr[left]=arr[left]+arr[left-1];
                    operation++;
                }
                else{
                    right--;
                    arr[right]=arr[right]+arr[right+1];
                }
            }
        }


        return operation;
    }
}
