/*
 * Question link - https://practice.geeksforgeeks.org/problems/sum-of-middle-elements-of-two-sorted-arrays2305/1
 */

public class SumOfMiddleElementOfTwoSortedArray {
    public static void main(String args[]){
        // int arr1[]={1, 2, 4, 6, 10};
        // int arr2[]={4, 5, 6, 9, 12};
        int arr1[]={1, 12, 15, 26, 38};
        int arr2[]={2, 13, 17, 30, 45};
        SumOfMiddleElementOfTwoSortedArray smeots=new SumOfMiddleElementOfTwoSortedArray();
        System.out.println(smeots.findMidSum(arr1, arr2, arr1.length));
    }

    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        int sum=ar1.length+ar2.length;
        int mid=sum/2;
        
        int i1=0;
        int i2=0;
        int count=0;
        int tempSum=0;
        int temp=0;
        
        if(sum==2){
            return ar1[0]+ar2[0];
        }
        
        while(i1<ar1.length || i2<ar2.length){
            if(i1<ar1.length && i2<ar2.length && ar1[i1]<ar2[i2]){
                temp=ar1[i1];
                i1++;
                count++;
            }
            else if(i1<ar1.length && i2<ar2.length && ar1[i1]>=ar2[i2]){
                temp=ar2[i2];
                i2++;
                count++;
            }
            else{
                if(i1<ar1.length){
                    temp=ar1[i1];
                    i1++;
                    count++;
                }
                else if(i2<ar2.length){
                    temp=ar2[i2];
                    i2++;
                    count++;
                }
            }
            
            if(count==mid || count==mid+1){
                tempSum+=temp;
                if(count==mid+1){
                    return tempSum;
                }
            }
            
        }
        
        return 0;
    }
}
