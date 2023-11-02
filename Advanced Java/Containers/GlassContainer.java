public class GlassContainer extends GeneralContainer {
	String pattern, answer;
	
	GlassContainer() {
		super();	
		material = "glass";
		
		System.out.println("\nDoes your container have a color patern? (answer yes or no) ");
		answer = input.nextLine();
		
		while (!"yes".matches(answer) && !"no".matches(answer)) {
			System.out.println("please try again");
			answer = input.nextLine();
		}
		
		if (answer.matches("yes")) {
			System.out.println("\nDescribe the colors and pattern of your container? ");
			color = input.nextLine();
		}
		else if (answer.matches("no")) {
			pattern = "\nThere wont be a pattern on your container.";
			
			changeColor();
		}
		System.out.println("\n\nThis is your container: ");
	}
	
	public String toString() {
		return "Its made of: " + material + "\nIs filled with: " + filling + "\nThe color is: " + color + "\nThe type of lid is: " + lid + "\nThe size of it is: " + size + "\nIts age is: " + age + "\nIts shape is: " + shape;
	}
}