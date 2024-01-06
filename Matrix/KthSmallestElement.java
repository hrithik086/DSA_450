/*
 * Question link - https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1
 * Explanation Video link of Similar question - https://www.youtube.com/watch?v=aNIfGl1ZKQE&t=1004s&ab_channel=ShashwatTiwari
 * Explanation video for this solution - https://www.youtube.com/watch?v=Q9wXgdxJq48&t=1178s&ab_channel=takeUforward
 */

public class KthSmallestElement {
    public static void main(String args[]){
        // int mat[][] = {{16, 28, 60, 64},
        //                 {22, 41, 63, 91},
        //                 {27, 50, 87, 93},
        //                 {36, 78, 87, 94 }
        //             };
        int mat[][] = {
            {7 ,17 ,27, 36, 38},
            {14, 23, 35, 38, 43},
            {19, 26, 42, 49, 50},
            {23, 33, 48, 52, 53},
            {30, 40, 52, 56, 64}
        };

        System.out.println(kthSmallestElement(mat, 13));

    }

    public static int kthSmallestElement(int mat[][], int index){
        int start=mat[0][0];
        int end=mat[mat.length-1][mat[mat.length-1].length-1];
        int mid=Integer.MIN_VALUE;
        int value=Integer.MIN_VALUE;
        int noOfSmallerElements;

        while(start <= end){
            mid = (start+end)/2;
            noOfSmallerElements = noOfElementsLessThanValueInMatrix(mat, mid);

            //it should capture the smallest value present in the sorted matrix
            //such that noOfElements which is <= this value in the matrix
            //this noOfElement should be just greater or equal to the index
            value = noOfSmallerElements >= index ? mid : value;

            if(noOfSmallerElements > index){
                end = mid-1;
            }
            else if(noOfSmallerElements < index){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return value;
    }

    public static int noOfElementsLessThanValueInMatrix(int mat[][], int value){
        int count=0;
        int tempCount=0;
        for(int i=0;i<mat.length;i++){
            tempCount=noOfElementsLessThanValueInArray(mat[i], value);
            count+=tempCount;
            if(tempCount==0){
                break;
            }
        }

        return count;
    }

    public static int noOfElementsLessThanValueInArray(int arr[], int value){

        int index=Integer.MIN_VALUE;
        int tempIndex;
        int start=0;
        int end=0;
        int mid=0;


        //get upper bound index
        if(value >= arr[arr.length-1]){
            return arr.length;
        }
        else if(value < arr[0]){
            return 0;
        }
        else{
            start=0;
            end=arr.length-1;

            while(start<=end){
                mid=(start+end)/2;

                if(arr[mid]>value){
                    tempIndex=mid;
                    //to pick the first occurence of that element in the sorted array
                    while(tempIndex>=0 && arr[tempIndex]==arr[mid]){
                        index=tempIndex;
                        tempIndex--;
                    }
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }

            }

        }

        return index;
    }
    
}
