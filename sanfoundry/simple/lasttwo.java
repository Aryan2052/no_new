package sanfoundry.simple;
import java.util.Scanner;

public class lasttwo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        int x = sc.nextInt();
        int a=0,i=0;
        String z = "";

        while(i<2){
            a = x%10;
            x=x/10;
            i++;

            z = a+""+z;
        }

        System.out.println("Last two digits are: " + z);
        sc.close();

    }
    
}
