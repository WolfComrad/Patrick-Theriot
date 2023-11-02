public class PlasticContainer extends GeneralContainer {
	double meltingPoint;
	
	PlasticContainer() {
		super();
		material = "plastic";
		
		System.out.println("\nWhat is the melting point of your container? (just type in a number) ");
		meltingPoint = input.nextDouble();
		input.nextLine();
		
		changeColor();
		
		System.out.println("\n\nThis is your container: ");
	}
	
	public String toString() {
		return "Its made of: " + material + "\nIs filled with: " + filling + "\nThe color is: " + color + "\nThe type of lid is: " + lid + "\nThe size of it is: " + size + "\nIts age is: " + age + "\nIts shape is: " + shape + "\nAnd its melting point is: " + meltingPoint;
	}
}