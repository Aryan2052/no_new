package Arrays.logic;
import java.util.*;

public class intersection {

    public static int[] findIntersection(int[] arr1, int[] arr2){

        List<Integer> ans = new ArrayList<>();
        int i=0, j=0;
        int n = arr1.length;
        int m = arr2.length;

        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                i++;
            } else if(arr1[i] > arr2[j]){
                j++;
            } else {
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        int ans1[] = new int[ans.size()];
        for(int k=0; k<ans.size(); k++){
            ans1[k] = ans.get(k);
        }
        return ans1;
    }
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};
        
        int[] result = findIntersection(arr1, arr2);
        
        System.out.print("Intersection: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    
}
