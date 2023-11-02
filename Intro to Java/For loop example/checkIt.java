//Patrick Theriot
import java.util.Scanner;
public class checkIt {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String answer = input.nextLine();
		boolean found = false;
		
		for ( int i = 0; i < answer.length(); i++ ) {
			if (answer.charAt(i) == 'i') {
				found = true;
			}
		}
		
		System.out.println(found);
		
	}
}