package hashing;

public class consequitive {

    public static boolean linearSearch(int[] arr, int num){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }
    public static int isConsecutive(int[] arr){
        int num = 0, max=1;

        for(int i=0; i<arr.length; i++){
            num = arr[i];
            int count = 1;
            while(linearSearch(arr, num+1)){
                count++;
                num++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(isConsecutive(arr));
    }
    
}
