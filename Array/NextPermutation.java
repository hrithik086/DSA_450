/*
 * question link - https://leetcode.com/problems/next-permutation/description/
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
        int swappedIndex;
        boolean isNextProbablityFound=false;

        //iterate from back and search for index where value in that index is less than its right index's value
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                imbalanceIndex=i-1;

                //sort the right sub array
                this.sortRightSubarray(nums, imbalanceIndex);

                //search for an element from the right subarray from imbalanceIndex position which is just greater that value at imbalanceIndex
                //and then swap
                swappedIndex=this.swapValueGreaterThanGivenValue(nums, imbalanceIndex);

                //balance the array as the sorted right subrray array got swapped by one element
                this.balanceRightSubarray(nums,imbalanceIndex,swappedIndex);

                isNextProbablityFound=true;
                break;
            }
        }

        if(!isNextProbablityFound){
            Arrays.sort(nums);
        }

        // System.out.println(Arrays.toString(nums));
        
    }

    //sort the right subarray
    public void sortRightSubarray(int nums[], int imbalanceIndex){
        int temp;
        int j;

        //perform insertion sort
        for(int i=imbalanceIndex+2;i<nums.length;i++){
            temp=nums[i];
            j=i;
            while(j>imbalanceIndex+1 && nums[j-1]>temp){
                nums[j]=nums[j-1];
                j--;
            }
            nums[j]=temp;
        }
    }

    //finds the index of smallest value which is greater than the value at imbalance and then swap it 
    public int swapValueGreaterThanGivenValue(int nums[], int imbalanceIndex){
        int temp=nums[imbalanceIndex];

        //as the right subarray is sorted in ascending order
        for(int i=imbalanceIndex+1;i<nums.length;i++){
            if(nums[i]>temp){
                nums[imbalanceIndex]=nums[i];
                nums[i]=temp;
                return i;
            }
        }
        return imbalanceIndex+1;
    }

    //balance the right subarray from particular position
    public void balanceRightSubarray(int nums[], int imbalanceIndex, int position){
        int temp;
        int i;

        //if there is imbalance towards the left
        if(position > imbalanceIndex+1 && position < nums.length-1 && nums[position]<nums[position-1]){
            temp=nums[position];
            i=position;

            while(i>imbalanceIndex+1 && nums[i-1]>temp){
                nums[i]=nums[i-1];
                i--;
            }
            nums[i]=temp;
        }

        if(position > imbalanceIndex+1 && position < nums.length-1 && nums[position]>nums[position+1]){
            temp=nums[position];
            i=position;

            while(i<nums.length-1 && temp>nums[i+1]){
                nums[i]=nums[i+1];
                i++;
            }
            nums[i]=temp;
        }
    }
}
