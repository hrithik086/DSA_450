/*
 * question link - https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
 */

import java.util.ArrayList;

public class FactorialOfLargeNumber {
    public static void main(String args[]){
        System.out.println(factorial(999));
    }

    static ArrayList<Integer> factorial(int N){
        
        int product;
        int carry;
        ArrayList<Integer> list=new ArrayList<Integer>();

        list.add(1);
        
        //i will hold the vallues like 
        //if N will be 5 then value of i will be i = 5, i = 4, i = 3,.....
        for(int i=N;i>0;i--){
            carry=0;
            //multiply each digit in the list with i
            for(int j=list.size()-1;j>=0;j--){
                product=(i*list.get(j))+carry;
                list.set(j,product%10);
                carry=product/10;
            }
            if(carry>0){
                if(carry>9){
                    while(carry!=0){
                        list.add(0,carry%10);
                        carry/=10;
                    }
                }
                else{
                    list.add(0,carry);
                }
            }
        }
        return list;
    }
}
