import java.util.*;
public class First {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.print(n+" ");

        while(n>1){
            if(n%2==0) n = (long)(n/2);
            else n = (long)(n*3 + 1);
            System.out.print(n+" ");
        }
    }

}
