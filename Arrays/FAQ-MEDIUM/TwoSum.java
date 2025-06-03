import java.util.*;

public class TwoSum {
    public int[] twosum(int[] nums, int target){
        //brute force is basically n^2 two loops
        //optimal, we will use a hashmap
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            int compliment = target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        int[] nums = {2,7,11,15,17,19,199,201,1,6,7,8,9,,5,4,3,2,4,1,0};
        int target = 9;

        int[] result = ts.twosum(nums, target);

        //printing the results
        if(result[0]!=-1 && result[1]!=-1){
            System.out.println("Indices of the two numbers that add up to " + target + " are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers add up to " + target);
        }
    }
    
}
