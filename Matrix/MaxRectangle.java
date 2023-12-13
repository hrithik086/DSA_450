/*
 * question link - https://practice.geeksforgeeks.org/problems/max-rectangle/1
 * Explanation Video link - https://www.youtube.com/watch?v=tOylVCugy9k&t=105s&ab_channel=takeUforward
 */

import java.util.Stack;

public class MaxRectangle {
    public static void main(String args[]) {
        int arr[][] = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };

        int max = new MaxRectangle().maxArea(arr,0,arr.length);
        System.out.println(max);
    }
    
    public int maxArea(int M[][], int n, int m) {
        
        int arr[] = new int[M[0].length];
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<M.length;i++){
            for(int j=0; j<M[0].length; j++){
                arr[j] = M[i][j] == 0 ? 0 : arr[j]+M[i][j];
            }
            max = Math.max(max, maxAreaInArray(arr));
        }
        
        return max;
    }
    
    //this function is same as function for maximum area of rectangle in a histogram
    public int maxAreaInArray(int arr[]){
        int lArr[] = leftSmallestIndexArray(arr);
        int rArr[] = rightSmallestIndexArray(arr);
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            max = Math.max(max, ((rArr[i]-lArr[i]+1)*arr[i]));
        }
        
        return max;
    }
    
    //calculate an array whose value denotes the left smallest index from that element
    public int[] leftSmallestIndexArray(int arr[]){
        int lArr[] = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i<arr.length;i++){
            
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                lArr[i]=0;
                stack.push(i);
            }
            else if(arr[stack.peek()]<arr[i]){
                lArr[i]=stack.peek()+1;
                stack.push(i);
            }
        }
        
        return lArr;
    }
    
    //calculate an array whose value denotes the right smallest index from that element
    public int[] rightSmallestIndexArray(int arr[]){
        int rArr[] = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=arr.length-1;i>=0;i--){
            
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                rArr[i]=arr.length-1;
                stack.push(i);
            }
            else if(arr[stack.peek()] < arr[i]){
                rArr[i] = stack.peek()-1;
                stack.push(i);
            }
        }
        
        return rArr;
    }
}
