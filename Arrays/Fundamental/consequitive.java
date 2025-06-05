package Arrays.Fundamental;

public class consequitive {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                count++;
                max = Math.max(max, count);
               
            }else{
                count = 0;
            }
        }
        return max;  
    }

    public static void main(String[] args){
        consequitive cs = new consequitive();
        int[] nums=  {1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1};
        int result = cs.findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }
    
}
