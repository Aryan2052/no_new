package strings;
import java.util.*;

//as both the remove and main method are static so no ned to create an instance of the class
//and we can call the remove method directly using the class name Outer.remove()//this is a simple program to remove all the vowels from a string
public class Outer {
    public static String remove(String s){

        if(s.length()==0) return "";

        //the following is a stack based approach to remove the outer parenthesis
        // Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // for(int i=0; i<s.length(); i++){

        //     if(s.charAt(i) =='('){
        //         if(st.size()!=0) sb.append(s.charAt(i));

        //         st.push('(');
        //     }else{
        //         st.pop();
        //         if(st.size()!=0) sb.append(s.charAt(i));
        //     }

        // }

        //counter based approach

        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                if(count>0) sb.append(s.charAt(i));
                count++;   
            }else{
                count--;
                if(count>0) sb.append(s.charAt(i));
            } 
        }

        return sb.toString();

    }
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = s.nextLine();

        String result = remove(input);
        System.out.println("String after removing parentheses: " + result);
        s.close();
    }
    
}
