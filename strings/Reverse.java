package strings;
import java.util.*;

public class Reverse {
    public static String reverse(String s){

        StringBuilder rev = new StringBuilder(s).reverse();
        System.out.println("Reversed String: " + rev.toString());
        String ans = "";

        for(int i=0; i<rev.length(); i++){

            StringBuilder word = new StringBuilder();

            while(i<rev.length() && rev.charAt(i) != ' '){
                word.append(rev.charAt(i));
                i++;
            }
            StringBuilder s2 = new StringBuilder(word).reverse();

            if(s2.length() > 0) {
                ans += s2.toString() + " ";
            }
        }

        return ans.trim();
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a new String:");
        String input = s.nextLine();

        String result = reverse(input);
        System.out.println("Reversed String: " + result);
    }
    
}
