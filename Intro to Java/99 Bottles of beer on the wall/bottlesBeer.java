//Patrick Theriot. Song= 99 Bottles of beer on the wall.

// 99 Bottles of beer on the wall
// 99 Bottles of beer
// Take one down, pass it around
// 98 Bottles of beer on the wall

public class bottlesBeer {
	public static void main(String[] args) {

		int numBeer = 99;
		
		while ( numBeer != 0) {
			
			System.out.println( numBeer + " Bottles of beer on the wall");
			System.out.println( numBeer + " Bottles of beer");
			System.out.println( numBeer + " Take one down, pass it around");
			numBeer--;
			if ( numBeer == 0) 
				System.out.println( "No more bottles of beer on the wall");
			else
				System.out.println( numBeer + " Bottles of beer on the wall");
		}
		
		System.out.println("\nONE MORE TIME!!!!!!");
		
		// this code is = to this next code
		
		/*for (int numBeer = 99 ; numBeer != 0 ; numBeers--) {
			// plus the rest of the code
		}*/
	}

}
