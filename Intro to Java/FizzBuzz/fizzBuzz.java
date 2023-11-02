import java.util.Scanner;
public class fizzBuzz {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int X = input.nextInt();
		int Y = input.nextInt();
		int N = input.nextInt();
		
		for (int i = 1; i < N + 1; i++ ) {
			
			if (i % X == 0 && i % Y != 0) {
				System.out.println("Fizz");
			}
			else if (i % Y == 0 && i % X != 0) {
				System.out.println("Buzz");
			}
			else if (i % X == 0 && i % Y == 0) {
				System.out.println("FizzBuzz");
			}
			else {
				System.out.println(i);
			}
		}
		input.close();
	}
}
