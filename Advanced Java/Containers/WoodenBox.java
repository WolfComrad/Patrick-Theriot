public class WoodenBox extends WoodenContainer {
	String engraving;

	WoodenBox() {
		super();
		
		System.out.println("\nWhat is the engraving you want to put on your box?");
		engraving = input.nextLine();
		
	}
	
	public String toString() {
		return "\n\nThis is your box: " + printProps() + "\nThis is the engraving you put on your box: "+ engraving;
	}
}