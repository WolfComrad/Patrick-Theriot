import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter numerator: ");
		double numer = s.nextDouble();
		System.out.print("Enter denominator: ");
		double denom = s.nextDouble();
		
		s.close();
		
		uselessDivider d = new uselessDivider();
		double div = 0.0; // declare outside of block because of the scope!
		try {
		div = d.divider(numer, denom); // might cause a problem...
		}
		catch (MyArithmeticException e) {
			// Much more graceful to the user of your program than an error message and the app crashing!
			System.out.println("Hey, user, division by zero is not allowed!");
			System.out.println("Error message: " + e);
			System.exit(0);
		}
		System.out.println("division = " + div);
		
		
		
		try {
			//code that might be problematic
		}
		catch (Exception e) { // Exception is a blanket type, avoid using it
			// if the problem you predicted happens, how to deal with it
		}
	}
}