import java.util.*;

public class sum{
    public static void findsum(int[] arr, int k){
        int sum = 0;
        int n = arr.length;

        //initial sum
        for(int i=0; i<k; i++){
            sum += arr[i];
        }

        for(int i=k; i<n; i++){
            //sliding the window
            sum = sum-arr[i-k] + arr[i];
            System.out.println("Sum of the window "+(i-k+2)+" is "+sum);
        }

    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int k=3;

        findsum(arr,k);
    }
}
