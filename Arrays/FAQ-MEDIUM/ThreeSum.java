import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        //brute force n^3 solution
        // Set<List<Integer>> tripleSet = new HashSet<>();

        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(triplet);
        //                 tripleSet.add(triplet);
        //             }
        //         }
        //     }
        // }

        // return new ArrayList<>(tripleSet);


        //optimal n^2 solution
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0; i<n; i++){
            HashSet<Integer> record = new HashSet<>();

            for(int j=0; j<n; j++){

                int third = -(nums[i] + nums[j]);
                if(record.contains(third)){
                    List<Integer> triplet = new ArrayList<>();

                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(third);

                    //sorting the collection
                    //so when we add in the result hashset, we dont get any duplicates
                    Collections.sort(triplet);
                    result.add(triplet);
                }
                //adding the element in the hashset, increasing the size of hashset
                record.add(nums[j]);
            }
        }
        //converting the hashset to arraylist
        List<List<Integer>> finalResult = new ArrayList<>(result);
        return finalResult;

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);

        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
