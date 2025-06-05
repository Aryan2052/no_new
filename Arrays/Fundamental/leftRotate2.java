package Arrays.Fundamental;

public class leftRotate2 {
    //function to rotate the array
    private void reverseArray(int[] nums, int start, int end) {

        while(start<end){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        
    }

    //function to left rotate
    public void rotateArray(int[] nums, int k){
        int n= nums.length;
        k=k%n;
        //first k elements
        reverseArray(nums, 0,k-1);

        // Reverse the last n-k elements
        reverseArray(nums, k, n - 1);

        // Reverse the entire array
        reverseArray(nums, 0, n - 1);
    }

    public static void main(String[] args){
        leftRotate2 lr = new leftRotate2();
        int[] nums = {1,2,3,4,5,6,7,89,};
        int k=2;

        lr.rotateArray(nums,k);
        for(int num: nums){
            System.out.println(num);
        }
    }
    
}
