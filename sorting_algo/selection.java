public class selection{
    public int[] sort(int[] nums){

        int n = nums.length;
        for(int i=0; i<n; i++){

            int min = i;
            for(int j=i+1; j<n; j++){
                if(nums[j]<nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];            
            nums[min] = temp;           
        }
        return nums;            
    }  
    
    public static void main(String[] args){
        selection s = new selection();
        int[] nums = {1,2,3,4,5,6,7,1,2,3,4,5,6,7};
        s.sort(nums);
        for(int num: nums){
            System.out.print(num + " ");
        }
    }
}

