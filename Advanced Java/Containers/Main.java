import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("what is your container made of? plastic, glass, or wood: ");
		String str = input.nextLine();
		
		while (!"plastic".matches(str) && !"glass".matches(str) && !"wood".matches(str)) {
			System.out.println("please try again");
			str = input.nextLine();
		}
		
		//plastic container
		if (str.matches("plastic")) {
			
			PlasticContainer c1 = new PlasticContainer();
			System.out.println(c1);
		}
		
		//glass container
		else if (str.matches("glass")) {
			
			GlassContainer c2 = new GlassContainer();
			System.out.println(c2);
		}
		
		//wood container
		else if (str.matches("wood")) {
			System.out.println("\nIs it a box or a container? ");
			String str2 = input.nextLine();
			
			while (!"box".matches(str2) && !"container".matches(str2)) {
				System.out.println("please try again");
				str2 = input.nextLine();
			}
			if (str2.matches("container")) {
				WoodenContainer c3 = new WoodenContainer();
				System.out.println(c3);
			}
			
			//wood box
			else if (str2.matches("box")) {
				WoodenBox c4 = new WoodenBox();
				System.out.println(c4);
			}
		}
	}
}