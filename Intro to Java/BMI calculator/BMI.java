/*
 * BMI CALCULATOR      						Patrick Theriot
 * 
 * A java program that reads in the user's height and weight as a double and prints out
 * both the calculated BMI and the interpretation of that BMI.
 * Liang textbook example 3.4
 * 
 * created: 9/23/2020				last modified: 9/23/2020
 */
import java.util.Scanner;

public class BMI {
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 
		 double weight;
		 double height;
		 double BMI;
		 
		 System.out.print("Enter height (in inches): ");
		 height = input.nextDouble();
		 System.out.print("Enter weight (in pounds): ");
		 weight = input.nextDouble();
		 
		 //BMI is = ( weight x 703 )/height^2
		 BMI = ( weight * 703 ) / height * height;
		 
		 BMI = (int) (BMI * 100) / 100.0;
		 
		 if ( BMI < 18.5 ) {
			 System.out.println("Your BMI is: " + BMI + " Interpretation is: Underweight.");
		 }
		 else if ( 18.5 <= BMI && BMI < 25.0 ) {
			 System.out.println("Your BMI is: " + BMI + " Interpretation is: Normal.");
		 }
		 else if ( BMI <= 25.0 && BMI < 30.0 ) {
			 System.out.println("Your BMI is: " + BMI + " Interpretation is: Overweight.");
		 }
		 else {
			 System.out.println("Your BMI is: " + BMI + " Interpretation is: Obese.");
		 }
	}
}