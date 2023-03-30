/*
 * question link - https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
 * Explanation video link - https://www.youtube.com/watch?v=D3BcHWmNX18
 * 
 * my explanation - just start with the first element and the value of arr[0] will be your next halt
 *                  this means i took the jump from i=0 to somewhere in between i+arr[i]
 *                  now my work is to find upto what maxIndex i can jump now once i get that i will jump to that section
 *                  as in the question they asked for minimum number of jumps we need to take long jumps so that's why we are looking for maxIndex we can go
 *                  maxIndex can be calculated by i+arr[i] this will give the maxIndex that i can go 
 */

public class MinimumJumps {
    public static void main(String args[]){
        // int arr[]={2,1,0,3};
        int arr[]= {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }

    static int minJumps(int arr[]){
        int halt=0;
        int maxIndex=0;
        int jump=0;
        boolean isMaxIndexChanged=false; //this is to check if the maxIndexValue is changing or not because in order to take next jump the maxIndex should get changed from the current maxIndex
                                         //if due to some reason the maxIndex is unable to change for example it got 0 somewhere it will return -1 as it won't be able to jump to end of the array.

        if(arr[0]==0){
            return -1;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0 && i+arr[i]>maxIndex){
                maxIndex=i+arr[i];
                isMaxIndexChanged=true;
            }

            if(i==halt){
                if(!isMaxIndexChanged){
                    return -1;
                }
                halt=maxIndex;
                jump++;
                if(halt>=arr.length-1){
                    return jump;
                }
                isMaxIndexChanged=false;
            }
        }

        return 0;
    }
}
