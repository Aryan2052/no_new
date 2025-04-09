//adjacent elemts are compared, and the largest is sorted at the last place 
// at the end of each iteration
import java.util.*;
public class bubblesort {
    public int[] bubbleSort(int[] nums) {

        int n = nums.length;

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++){
                if(nums[j+1]<nums[j]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args){
        bubblesort b = new bubblesort();

        int nums[] = {1,2,3,4,5,99,88,678,9876783,1,34,53,77};
        b.bubbleSort(nums); 
        System.out.printf("Sorted array is: ", Arrays.toString(nums));
    }
}
