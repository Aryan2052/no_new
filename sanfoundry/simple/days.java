package sanfoundry.simple;
import java.util.Scanner;


public class days {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number of days:");
        int days = sc.nextInt();

        int year=0, week=0;
        year = days/365;
        days = days%365;
        
        week = days/7;
        days = days%7;

        System.out.println("Equivalent to: " + year + " years, " + week + " weeks, and " + days + " days.");
        sc.close();
    }
    
}
