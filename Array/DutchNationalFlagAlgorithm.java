import java.util.Arrays;

/*
 *  question link - https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
 * 
 *  Algorithm used - Dutch National Flag Algorithm - This is an algorithm where there will be three pointer the front pointer will
 * store small values the middle poiter will store mid values and the last pointer will store large values.
 */

public class DutchNationalFlagAlgorithm {
    public static void main(String args[]){
        int arr[]={-12, 11, -13, -5, 6, -7, 5, -3, -6};
        dutchNationalFlagAlgorithm(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void dutchNationalFlagAlgorithm(int arr[]){
        //we are having only negative and positive values we dont have some values which can be pointed in mid pointer so
        //we won't be using mid pointer 
        int negativeIndex=-1;
        int positiveIndex=arr.length;

        for(int i=0;i<arr.length && i< positiveIndex;i++){
            if(arr[i]<0){
                negativeIndex++;
                swap(arr,i,negativeIndex);
            }
            else{
                positiveIndex--;
                swap(arr,i,positiveIndex);
            }
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}
