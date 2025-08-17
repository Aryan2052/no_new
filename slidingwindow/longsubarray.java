import java.util.*;
public class longsubarray {

    public static void findlongg(int[] arr, int k){
        int sum = 0;
        int maxlen = 0;

        int right = 0, left=0;
        for(int i=right; i<arr.length; i++){
            sum += arr[i];
            while(sum>k){
                sum -=arr[left];
                left++;
            }

            maxlen = Math.max(maxlen, i-left +1);
        }
        System.out.println("Length of the longest subarray with sum less than or equal to " + k + " is: " + maxlen);
    }
    public static void main(String[] args){
        int[] arr = {2, 5, 1, 7, 10}; // Example array
        int k = 14; // Example value of K

        findlongg(arr, k);
    }
    
}
