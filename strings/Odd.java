package strings;
import java.util.*;


public class Odd {
    public static String findnum(String s){

        String s1 = "";
        for(int i=s.length()-1; i>=0; i--){
            if(Character.getNumericValue(s.charAt(i))%2!=0){
                return s.substring(0, i+1);
            }
        }
        return s1;
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = s.nextLine();

        String result = findnum(input);
        System.out.println("String after removing odd numbers: " + result);

    }

    
}
