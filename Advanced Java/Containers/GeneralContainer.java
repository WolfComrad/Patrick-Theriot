import java.util.Scanner;
abstract class GeneralContainer {
	protected String material, color, filling, lid, size, age, shape;
	Scanner input = new Scanner(System.in);
	
	GeneralContainer() {
		System.out.println("\n" + "What is its color? ");
		color = input.nextLine();
		System.out.println("\n" + "What is its size? (small, medium, or big) ");
		size = input.nextLine();
		System.out.println("\n" + "Does it have something in it? (answer yes or no) ");
		filling = input.nextLine();
		
		while (!"yes".matches(filling) && !"no".matches(filling)) {
			System.out.println("please try again");
			filling = input.nextLine();
		}
		if (filling.matches("yes")) {
			System.out.println("\nWhat is inside it?");
			this.filling = input.nextLine();
		}
		else if (filling.matches("no")) {
			this.filling = "nothing";
		}
		
		System.out.println("\n" + "What type of lid does it have? (latch, snap on, screw on, or hidden lid) ");
		lid = input.nextLine();
		System.out.println("\n" + "What's its age? ");
		age = input.nextLine();
		System.out.println("\n" + "What is the shape of it? ");
		shape = input.nextLine();
	}
	
	public abstract String toString();
	
	public void changeColor() {
		
		System.out.println("\nDo you wish to change the color? (yes or no) ");
		String colorChange = input.nextLine();
		
		while (!"yes".matches(colorChange) && !"no".matches(colorChange)) {
			
			colorChange = input.nextLine();
			System.out.println("please try again");
		}
		
		if (colorChange.matches("yes")) {
			System.out.println("\nWhat is the color you wish to change it to? ");
			color = input.nextLine();
			System.out.println("\nYour color has been changed to: " + color);
		}
		else if (colorChange.matches("no")) {
			System.out.println("Your color shall remain the same.");
		}
	}
}