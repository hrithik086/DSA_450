/*
 * Question link - https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * Explanation Video link - https://www.youtube.com/watch?v=X0X6G-eWgQ8&ab_channel=takeUforward
 */

import java.util.Stack;

public class LargestRectangleInHistogram{
    public static void main(String args[]){
        int heights[] = {2,1,5,6,2,3};
        LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();
        System.out.println(lrih.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int lli[] = this.leftLimitIndexArray(heights); //function to calculate the left smallest index of the array
        int rli[] = this.rightLimitIndexArray(heights);//function to calculate the right smallest index of the array
        // System.out.println(Arrays.toString(lli));
        // System.out.println(Arrays.toString(rli));
        int max = Integer.MIN_VALUE;
        int area=0;

        for(int i=0;i<heights.length;i++){
            area = (rli[i]-lli[i]+1)*heights[i];
            if(area > max){
                max=area;
            }
        }
        return max;
    }

    //Calculate left smallest element of the array
    public int[] leftLimitIndexArray(int[] heights){
        Stack<Integer> stack=new Stack<Integer>();
        int[] lli = new int[heights.length];

        for(int i=0;i<heights.length;i++){
            if(stack.empty()){
                lli[i]=0;
                stack.push(i);
            }
            else{
                while(!stack.empty() && heights[i] <= heights[stack.peek()]){
                    stack.pop();
                }
                if(stack.empty()){
                    lli[i]=0;
                    stack.push(i);
                }
                else{
                    lli[i]=stack.peek()+1;
                    stack.push(i);
                }
            }
        }
        return lli;
    }

    //calculate right smallest element in the array
    public int[] rightLimitIndexArray(int[] heights){
        int rli[]=new int[heights.length];
        Stack<Integer> stack = new Stack<Integer>();
        int maxLength=heights.length-1;

        for(int i=heights.length-1;i>=0;i--){
            if(stack.empty()){
                rli[i]=maxLength;
                stack.push(i);
            }
            else{
                while(!stack.empty() && heights[i]<=heights[stack.peek()]){
                    stack.pop();
                }
                if(stack.empty()){
                    rli[i]=maxLength;
                    stack.push(i);
                }
                else{
                    rli[i]=stack.peek()-1;
                    stack.push(i);
                }
            }
        }
        return rli;
    }
}