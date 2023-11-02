//Patrick Theriot,
public class divide {
	public static void main(String[] args) {
		//Making values
		int n = 7;
		int d = 2;
		int r = 0;
		int q = 0;
		
		/*continually subtract the denominator from the numerator to "count"
		 * the quotient and leave the remainder.*/
		while ( (n - d) >= 0) {
			n = n - d;
			q++;
		}
		
		System.out.print(q + "r");
		System.out.print(n);
		
	}
}