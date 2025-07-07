package Arrays.logic;


public class movezero {
    public static void remove(int[] arr){

        //brute force temp array to store the non neagtive eelements
        //and then copy them back to the original array
        // int[] temp = new int[arr.length];
        // int i =0;

        // for(int n: arr){
        //     if(n>0){
        //         temp[i++] = n;
        //     }
        // }
        // for(int j = 0; j<i; j++){
        //     arr[j] = temp[j];
        // }
        // for(int j = i; j<arr.length; j++){
        //     arr[j] = 0;
        // }

        //Optimized approach
        int j = 0;

        for(int n:arr){
            if(n!=0){
                arr[j++] = n;
            }
        }

        for(int i = j; i<arr.length; i++){
            arr[i] = 0;
        }

    }
    public static void main(String[] args){
        int[] arr = {1,12,3,4,0,0,0,9,8,9,6,5};

        remove(arr);
        for(int n: arr){
            System.out.println(n);
        }
    }
    
}
