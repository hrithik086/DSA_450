/*
 * Question link - https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
 */

public class RowWithMax1s {
    public static void main(String args[]){
        // int arr[][]={{0, 1, 1, 1},
        //             {0, 0, 1, 1},
        //             {1, 1, 1, 1},
        //             {0, 0, 0, 0}};
        // int n=4;
        // int m=4;

        int arr[][]={{0, 0}, {1, 1}};
        int n=2;
        int m=2;

        RowWithMax1s rwm=new RowWithMax1s();
        System.out.println(rwm.rowWithMax1s(arr, n, m));
    }

    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int max=Integer.MIN_VALUE;
        int maxI=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i][arr[i].length-1]==0){
                // if(0 >= max){
                //     maxI=i;
                //     continue;
                // }
                continue;
            }
            else if(arr[i][0]==1){
                return i;
            }
            else{
                for(int j=0;j<arr[i].length;j++){
                    if(arr[i][j]==1){
                        if((arr[i].length-j) > max){
                            max=(arr[i].length-j);
                            maxI=i;
                        }
                    }
                }
            }
        }
        return maxI;
    }
}
