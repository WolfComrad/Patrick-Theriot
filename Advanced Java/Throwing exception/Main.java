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
		double div = d.divider(numer, denom);
		
		System.out.println("division = " + div);
	}
}