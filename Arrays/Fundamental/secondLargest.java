package Arrays.Fundamental;
public class secondLargest {
    public int secondLargestElement(int[] nums) {

        int secondLargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i]>largest){
                secondLargest = largest;
                largest = nums[i];
            }else if(nums[i]>secondLargest && nums[i]!=largest){
                secondLargest = nums[i];
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1: secondLargest;
    
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        secondLargest sl = new secondLargest();
        int result = sl.secondLargestElement(nums);
        System.out.println(result);
    }
}