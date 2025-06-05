package Arrays.Fundamental;

public class leftRotate {
    public void rotateArrayByOne(int[] nums) {

        int first = nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = nums[i];
            nums[i-1]=temp;
            nums[i]=first;
        }
        
    }

    public static void main(String[] args){
        leftRotate lr = new leftRotate();
        int[] nums = {1,2,3,4,5,6,7,89,};

        lr.rotateArrayByOne(nums);
        for(int num: nums){
            System.out.println(num);
        }
    }
    
}
