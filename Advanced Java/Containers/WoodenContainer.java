public class WoodenContainer extends GeneralContainer {
	int nails;
	
	WoodenContainer() {
		super();	
		material = "wood";
		
		System.out.println("\nHow many nails does it have? (answer in numbers. The answer has to be under 1000000) ");
		nails = input.nextInt();
		input.nextLine();
		
		changeColor();		
	}
	public String toString() {
		return "\n\nThis is your container: " + printProps();
	}
	
	public String printProps() {
		return  "\nIts made of: " + material + "\nIs filled with: " + filling + "\nThe color is: " + color + "\nThe type of lid is: " + lid + "\nThe size of it is: " + size + "\nIts age is: " + age + "\nIts shape is: " + shape + "\nAnd it has " + nails + " nails";
	}
}