//Patrick Theriot. you get to play the high low game.

import java.util.Scanner;
public class highLow {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int x = (int)(Math.random() * 100) + 1;
	
		System.out.print("Pick a number between 1 and 100. ");
		int answer = input.nextInt();
		
		while (answer < x ) {
			System.out.print("Your low. Try again. ");
			answer = input.nextInt();
		}
		while (answer > x ) {
			System.out.print("Your high. Try again. ");
			answer = input.nextInt();
		}
		
		System.out.println("You got it right!");
	}
}