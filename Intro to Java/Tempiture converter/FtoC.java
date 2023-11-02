//Patrick Theriot, w0702809, CMPS 161
import java.util.Scanner;
public class FtoC {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double celsius;
		double fahrenheit = input.nextDouble();
		
		celsius = (5.0/9.0) * (fahrenheit - 32.0);
		
		System.out.print("put tempureture here: ");
		System.out.print(celsius);
				
	}
}