package Arrays.Fundamental;


public class linearSearch {
    public int linearsearch(int nums[], int target) {
		//Your code goes here

        for(int i=0; i<nums.length; i++){
            if(nums[i]==target) return i;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        int target = 4;

        linearSearch ls = new linearSearch();
        int result = ls.linearsearch(nums, target);
        System.out.println(result);
    }
}
