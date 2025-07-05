package strings;
import java.util.*;


public class Common {
    public static String findcommon(String[] arr){

        if(arr.length==0) return "";
        
        Arrays.sort(arr);
        StringBuilder s1 = new StringBuilder();
        String First = arr[0];
        String Last = arr[arr.length-1];

        for(int i=0; i<Math.min(First.length(), Last.length()); i++) {

            if(First.charAt(i)!=Last.charAt(i)){
                return s1.toString();
            }
            s1.append(First.charAt(i));
        }
        return s1.toString();
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of string array:");
        int x = s.nextInt();
        s.nextLine(); // fix to consume leftover newline

        String[] arr = new String[x];

        for(int i=0; i<x; i++){
            arr[i] = s.nextLine();
        }

        String result = findcommon(arr);
        System.out.println("The common prefix is: " + result);
        s.close();
    }
}
