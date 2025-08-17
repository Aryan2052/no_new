import java.util.*;
public class Missing {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] arr = new long[(int)(n-1)];
        long sum = 0L;

        for(int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextLong();
            sum += arr[i];
        }

        System.out.println(n*(n+1)/2-sum);
        sc.close();
    }
}
