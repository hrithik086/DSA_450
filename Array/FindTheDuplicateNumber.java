/*
 *                                              Floyd's Cycle Detection Algorithm
 * 
 * Question link - https://leetcode.com/problems/find-the-duplicate-number/description/
 * 
 * Floyd's Cycle Detection Algorithm explanation video - https://www.youtube.com/watch?v=jcZtMh_jov0&ab_channel=AnujBhaiya
 * Question's explanation video - https://www.youtube.com/watch?v=32Ll35mhWg0&ab_channel=takeUforward
 * 
 */

public class FindTheDuplicateNumber {
    public static void main(String args[]){
        int arr[]={1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int head=nums[0];
        int fastPointer=nums[nums[head]];
        int slowPointer=nums[head];

        while(fastPointer != slowPointer){
            slowPointer=nums[slowPointer];
            fastPointer=nums[nums[fastPointer]];
        }
        // System.out.println("fastPointer and slowPointer meet at "+ fastPointer);
        if(fastPointer==slowPointer){
            slowPointer=nums[0];
            while(slowPointer!=fastPointer){
                slowPointer=nums[slowPointer];
                fastPointer=nums[fastPointer];
            }
            if(slowPointer==fastPointer){
                return slowPointer;
            }
        }
        return -1;
    }
}
