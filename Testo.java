// class Calculator {

//     int a;//variable of the class

//     public int add(int num1, int num2) {
//         System.out.println("This is the add method of Calculator class");
//         int r = num1 + num2; // Using the variables from the main method
//         return r;
//     }
// }

// public class Demo {
//     public static void main(String[] args) {
//         int num1 = 2;
//         int num2 = 4;

//         Calculator calc = new Calculator();
//         //the initial part of above line is called reference variable, calc is the reference variable name

//         int resultt = calc.add(num1, num2);
//         System.out.println("The sum of " + num1 + " and " + num2 + " is: " + resultt);
//     }
    
// }

class Computer {
    private String brand;
    private int price;

    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("Brand set to: " + brand);
    }

    public void setPrice(int price){
        this.price = price;
        System.out.println("Price set to: " + price);
    }

    public int quantity(int a, int b, int c){
        return a+b+c;
    }
    public int quantity(int a, int b){
        return a+b;
    }
}


public class Testo {
    public static void main(String[] args) {
        
        Computer obj = new Computer();
        obj.setBrand("Dell");
        obj.setPrice(50000);
        int res1 = obj.quantity(1,2,3);
        System.out.println("res1"+res1);
        int res2 = obj.quantity(100,369);
        System.out.println("res2 "+res2);
    }
    
}



