abstract class Operations{
    float a = 12, b=6, c;
    abstract void add();
    void subtarct(){
        c = a-b;
        System.out.println("Subtraction: " + c);
    }

    abstract void multiply();
    void divide(){
        c = a/b;
        System.out.println("Division: " + c);
    }

}
public class abs extends Operations{

    void add() {
        c = a + b;
        System.out.println("Addition: " + c);
    }
    void multiply() {
        c = a * b;
        System.out.println("Multiplication: " + c);
    }

    public static void main(String[] args){
        abs obj = new abs();
        obj.add();
        obj.subtarct();
        obj.multiply();
        obj.divide();
    }
    
}
