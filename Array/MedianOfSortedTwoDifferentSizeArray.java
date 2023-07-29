/*
 * Question link - https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
 */

public class MedianOfSortedTwoDifferentSizeArray {
    public static void main(String args[]){
        // int arr1[]={1,5,9};
        // int arr2[]={2,3,6,7};
        int arr1[]={4,6};
        int arr2[]={1,2,3,5};
        System.out.println(medianOfArrays(arr1.length, arr2.length, arr1, arr2));
    }

    static double medianOfArrays(int n, int m, int ar1[], int ar2[]) 
    {
        // Your Code Here
        int sum=ar1.length+ar2.length;
        int mid=sum/2;
        boolean isEven=sum%2==0 ? true : false;
        
        int i1=0;
        int i2=0;
        int count=0;
        int tempSum=0;
        int temp=0;
        
        // if(sum==2){
        //     return ar1[0]+ar2[0];
        // }
        
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
            
            if(isEven && (count==mid || count==mid+1)){
                tempSum+=temp;
                if(count==mid+1){
                    return tempSum/2.0;
                }
            }
            else if(!isEven && count==mid+1){
                return temp;
            }
            
        }
        
        return 0;
    }
}
