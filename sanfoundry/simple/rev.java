package sanfoundry.simple;
import java.util.Scanner;

public class rev {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to reverse:");
        int x = sc.nextInt();

        // for(int i=x; i!=0; i=i/10){

        //     int r = i % 10;
        //     revv = revv*10 + r;
        // }

        // System.out.println("Reversed number is: " + revv);

        //using recursion
        int count = 0;
        int n = x;
        

        while(x>0){
            count++;
            x = x / 10;
        }
        int revv = recursion(n, count);
        
        System.out.println("Reversed number is: " + revv);
        sc.close();


    }
    private static int recursion(int x, int length){

        if(length==1){
            return x;
        }
        else{
            int r = x%10;
            return (int) ((r*Math.pow(10,length-1))+recursion(x/10, length-1));
    }
    
}
}
