import java.util.*;
class Calculator {
    public static double findavg(int n1, int n2, int n3){
        
        double sum = n1+n2+n3;
        double avg = sum/3.0;
        return avg;
    }

	// Implement your code here
}

public class avg {

	public static void main(String args[]) {
		Calculator calculator = new Calculator();
		
		Scanner s = new Scanner(System.in);
		
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		int n3 = s.nextInt();
		
		double result = calculator.findavg(n1, n2, n3);
		System.out.println(result);
		// Invoke the method findAverage of the Calculator class and display the average
	}
}