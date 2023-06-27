/*
 * question link - https://leetcode.com/problems/next-permutation/description/
 * explanation video link - https://www.youtube.com/watch?v=TOvWyFT0xCw&ab_channel=Yogesh%26Shailesh%28CodeLibrary%29
 */

import java.util.Arrays;

public class NextPermutation {
    public static void main(String args[]){
        NextPermutation np=new NextPermutation();
        int nums[]={2,1,3,2,1};
        np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int imbalanceIndex;
        boolean isNextProbablityFound=false;

        //iterate from back and search for index where value in that index is less than its right index's value
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                imbalanceIndex=i-1;

                //check for smallest value in right subarray which is greater than value at imbalanceIndex
                //then swap the element
                this.swapValueGreaterThanGivenValue(nums, imbalanceIndex);

                //sort the right array in ascending order
                sortRightSubarray(nums, imbalanceIndex);

                isNextProbablityFound=true;
                break;
            }
        }

        if(!isNextProbablityFound){
            sortRightSubarray(nums,-1);
        }

        // System.out.println(Arrays.toString(nums));
        
    }

    //sort the right subarray to ascending order
    public void sortRightSubarray(int nums[], int imbalanceIndex){
        //as the right subarray is already in descending order
        //we just need to reverse the order to get the ascending order
        int i=imbalanceIndex+1;
        int j=nums.length-1;

        while(i<j){
            nums[i]+=nums[j];
            nums[j]=nums[i]-nums[j];
            nums[i]-=nums[j];
            i++;
            j--;
        }
    }

    //finds the index of smallest value which is greater than the value at imbalance and then swap it 
    public void swapValueGreaterThanGivenValue(int nums[], int imbalanceIndex){
        int temp=nums[imbalanceIndex];
        int maxIndex=-1;

        //as the right subarray is sorted in descending order
        for(int i=imbalanceIndex+1;i<nums.length;i++){
            if(nums[i]>temp){
                maxIndex=i;
            }
            else if(nums[i]<temp){
                break;
            }
        }

        if(maxIndex>-1){
            nums[imbalanceIndex]=nums[maxIndex];
            nums[maxIndex]=temp;
        }
    }
        
}
