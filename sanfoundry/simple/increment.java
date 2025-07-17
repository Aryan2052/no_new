package sanfoundry.simple;
import java.util.Scanner;

public class increment {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        int x,m = 0, a;
        System.out.println("Enter a number to increment:");
        x = sc.nextInt();

        //we have the reversed no
        while(x>0){
            a = x%10;
            a++;
            m = m*10 + a;
            x = x/10;
        }

        System.out.println("Reversed incremented number is: " + m);

        //reverse again to get the num
        x = m;
        m = 0;
        while(x>0){
            a = x%10;
            m = m*10 + a;
            x = x/10;
        }

        System.out.println("Incremented number is: " + m);
        sc.close();

    }
    
}
