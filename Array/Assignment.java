import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Assignment {
    public static void main(String args[]){
        Random r=new Random();
        List<Integer> list=new ArrayList<>();

        //generating random numbers
        for(int i=0;i<34279;i++){
            list.add(r.nextInt(130000)+(-80000));
        }
        
        //Sorting in ascending order
        quickSort(0, list.size()-1, list);
        
        //printing 10 largest number
        for(int i=list.size()-1;i>=(list.size()-10);i--){
            System.out.println(list.get(i));
        }
    }

    public static void quickSort(int low, int high, List<Integer> arr){
        if(low<high){
            int partition=partition(0, high, arr);
            quickSort(low, partition-1, arr);
            quickSort(partition+1, high, arr);
        }
    }

    public static int partition(int low, int high, List<Integer> arr){
        int temp=0;
        int pivot=arr.get(high);
        int index=low-1;
        for(int i=low;i<=high-1;i++){
            if(arr.get(i)<=pivot){
                index++;
                temp=arr.get(i);
                arr.set(i, arr.get(index));
                arr.set(index, temp);
            }
        }
        index++;
        temp=arr.get(high);
        arr.set(high, arr.get(index));
        arr.set(index, temp);
        return index;
    }
}
