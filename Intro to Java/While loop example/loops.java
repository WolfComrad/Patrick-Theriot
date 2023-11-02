//Patrick Theriot.

import java.util.Scanner;
public class loops {
	public static void main(String[] args) {
		Scanner input = new Scanner ( System.in );
		int x = (int)(Math.random() * 10) + 1;
		int y = (int)(Math.random() * 10) + 1;
		int number = 0;
		
		System.out.print("What is " + x + " + " + y + "? ");
		int answer = input.nextInt();
		
		while (answer == (x + y )) {
			System.out.print( "Correct! " );
			x = (int)(Math.random() * 10) + 1;
			y = (int)(Math.random() * 10) + 1;
			System.out.print("What is " + x + " + " + y + "? ");
			answer = input.nextInt();
			number++;
		}
		
		System.out.println("That was incorrect.");
		System.out.println("You got " + number + " correct.");
	}
}