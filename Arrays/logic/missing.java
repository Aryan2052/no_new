package Arrays.logic;

public class missing {

    public static int findMissing(int[] arr){
        int n=arr.length;
        int sum = (n * (n + 1)) / 2; // Sum of first n natural numbers
        int arrSum = 0;

        for(int num: arr){
            arrSum += num; // Calculate the sum of elements in the array
        }
        return sum-arrSum;
    }
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 3, 5};

        int result = findMissing(arr);
        System.out.println("The missing number is: " + result);
    }
    
}
