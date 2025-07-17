package sanfoundry.simple;
import java.util.Scanner;

public class binary {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to convert to binary:");
        int x = sc.nextInt();

        String ans = toBinary(x);
        System.out.println("Binary representation is: " + ans);
        sc.close();
    }
    private static String toBinary(int x){
        if(x>0){
            int a = x%2;
            x = x/2;
            return toBinary(x)+ ""+a;
        }
        else{
            return "";
        }
    }
    
}
