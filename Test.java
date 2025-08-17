import java.util.*;
public class Test {
    private static int value;
    
    public static void main(String[] args) {
        int num1 = 5;
        byte by = 127;
        value = 123;
        System.out.println("Initial value: " + value);
        
        short sh = 558;
        long l = 123456789L;
        float f = 3.14f;
        double d = 3.14;

        char ch = 'A';
        char ch1 = '8';

        int num11 = 0b01;
        int num12 = 0x1F;
        int num13 = 0_123_00_000;



        //type conversion
        int a = 12345;  //12345%256 because complete range of byte is 256
        byte b = (byte) a; // explicit conversion
        System.out.println("Converted byte value: " + b);

        float f1 = 123.45f;
        int i = (int) f1; // explicit conversion

        byte by1 = 100;
        byte by2 = 50;
        int i1 = by1*by2; // implicit conversion to int    type promotion
        System.out.println("Sum of bytes as int: " + i1);
        byte by3 = (byte) (by1 + by2); // explicit conversion


        int i2 = 101;
        int i3 = 20;
        int i4 = i2/i3; // we get quotient
        System.out.println("Quotient of integers: " + i4);

        if(i2>100 && i3<30) {
            System.out.println("Condition met: i2 is greater than 100 and i3 is less than 30");
        } else {
            System.out.println("Condition not met");
        }

        boolean isTrue = true;

        isTrue = i2%2==0 ? true : false; // ternary operator
        System.out.println("Is i2 even? " + isTrue);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();
        System.out.println("You entered: " + n);   
        
        switch(n){
            case(1):
                System.out.println("Sunday");
                break;
            case(2):
                System.out.println("Monday");
                break;
            case(3):
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
            System.out.println("Saturday");
            break;
            default:
            System.out.println("Invalid day");
        }

        // int ii=0;
        // while(true){
        //     System.out.println("Hello, World!"+ ii);
        //     ii++;
        // }// infinite loop example

        for(int k=0; k<5; k++){

            System.out.println("Loop iteration: " + k);
            for(int j=1; j<10; j++){
                System.out.println(" "+(j+8)+"-"+(j+9));
            }

        }

        





    }
}
