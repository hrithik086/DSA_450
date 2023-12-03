import java.util.Arrays;

public class MergeSort {
    
    public static void main(String args[]){
        int arr[] = {8,3,4,2,0,0,3,9,0,9};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int arr[], int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr, m+1, r);
            merge(arr,l,m,r);
        }
    }

    public static void merge(int arr[], int l, int m, int r){
        int lArr[] = new int[m-l+1];
        int rArr[] = new int[r-m];

        //fill the left subarray and right subarray
        int j=0;
        int k=0;
        int i;
        for(i=l;i<=r;i++){
            if(i<=m){
                lArr[j]=arr[i];
                j++;
            }
            else{
                rArr[k]=arr[i];
                k++;
            }
        }

        //compare the two subarray and fill the array in sorted order
        j=0; //pointer for left subarray
        k=0; //pointer for right subarry
        for(i=l; i<=r && j<lArr.length && k<rArr.length ; i++){
            if(lArr[j]<rArr[k]){
                arr[i]=lArr[j];
                j++;
            }
            else{
                arr[i]=rArr[k];
                k++;
            }
        }

        while(j < lArr.length){
            arr[i]=lArr[j];
            i++;
            j++;
        }

        while(k < rArr.length){
            arr[i]=rArr[k];
            i++;
            k++;
        }
    }

}
