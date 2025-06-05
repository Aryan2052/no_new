package Arrays.Fundamental;

public class largest {
    public int largestElement(int[] nums) {

        int largest = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>largest) largest = nums[i];
        }

        return largest;
    
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        largest ls = new largest();
        int result = ls.largestElement(nums);
        System.out.println(result); // Output: 5
    }   
    
}
