import java.util.Arrays;

public class QuickSort{
    public static void main(String args[]){
        QuickSort qs = new QuickSort();
        int arr[]={8,3,4,2,0,0,3,9,0,9};
        qs.sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int arr[], int left, int right){
        if(left<right){
            int partitionPoint = partition(arr,left,right);
            sort(arr, left, partitionPoint - 1);
            sort(arr, partitionPoint + 1, right);
        }
    }

    public int partition(int arr[], int left, int right){
        int pivot=right;
        int pointer=left;

        for(int i=left;i<right;i++){
            if(arr[i]<arr[pivot]){
                swap(arr, pointer, i);
                pointer++;
            }
        }

        swap(arr, pivot, pointer);

        return pointer;
    }

    public void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}