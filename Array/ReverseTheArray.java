/*
 * Question link - https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 * Question name - Reverse the array in geeks for geeks
*/

package Array;

public class ReverseTheArray {
    public static void main(String args[]){
        System.out.println("hello  world");
        System.out.println(reverseWord("hrithik"));
    }

    public static String reverseWord(String str){
        String start="";
        String end="";

        for(int i=0,j=str.length()-1;i<=j;i++,j--){
            if(i==j){
                start+=str.charAt(j);
                continue;
            }
            
            start+=str.charAt(j);
            end=str.charAt(i)+end;
        }

        return start+end;
    }
}
