package Arrays.logic;

public class duplicate {

    public static int remove(int[] arr){

        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != arr[j]){
                j++;
                arr[j] = arr[i]; 
            }
        }

        return j;
    }
    public static void main(String[] args){
        int[] arr1 = {0, 0, 1, 1, 2, 2, 2, 3, 4, 5, 6};

        int result = remove(arr1);
        for(int i=0; i<=result; i++){
            System.out.print(arr1[i] + " ");
        }
    }
}
