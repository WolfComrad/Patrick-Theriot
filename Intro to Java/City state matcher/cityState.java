/* CMPS 161-04 Assignment 5, Patrick Theriot,
W0702809.

This assignment will read in 5 strings from the user
in the form of City, State. Then it will check and see
if the input is in the form it should be in. And then 
it will print out which City shares the same states.*/

import java.util.Scanner;
public class cityState {
	
	//this method checks to see if the inputs have the same state. 
	public static boolean sameState( String c1, String c2 ){
		
		if (c1.substring(c1.length() - 2).equals(c2.substring(c2.length() - 2))) {
			return true;
		}
		
		return false;
	}
	
	//this method checks the input to make sure it is in the form of City, State.
	public static boolean checkString( String c ){
		
		if(c.charAt(c.length() - 4) == ',' && c.charAt(c.length() - 3) == ' ') {
			return true;
		}
		else {
			return false;
		}
	}
	
	//this method asks for the input.
	public static String getInput(int num) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("City " + num + ": ");
		String city = input.nextLine();
		
		//this calls upon the checkString method.
		Boolean check = checkString(city);
		while (check == false) {
			System.out.println("Error, Please re-enter");
			
			System.out.print("City " + num + ": ");
			city = input.nextLine();
			check = checkString(city);
		}
		
		return city;
	}
	
	//this is the main method/ the go square.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 1;
		
		//these lines stores the users input.
		String input1 = getInput(num);
		num++;
		String input2 = getInput(num);
		num++;
		String input3 = getInput(num);
		num++;
		String input4 = getInput(num);
		num++;
		String input5 = getInput(num);
		
		//these if statements print a line only if sameState method is true. 
		if (sameState(input1, input2)) {
			System.out.print("\n" + input1 +"; "+ input2);
		}
		if (sameState(input1, input3)) {
			System.out.print("; " + input1 +"; "+ input3);
		}
		if (sameState(input1, input4)) {
			System.out.print("; " + input1 +"; "+ input4);
		}
		if (sameState(input1, input5)) {
			System.out.print("; " + input1 +"; "+ input5);
		}
		if (sameState(input2, input3)) {
			System.out.print("; " + input2 +"; "+ input3);
		}
		if (sameState(input2, input4)) {
			System.out.print("; " + input2 +"; "+ input4);
		}
		if (sameState(input2, input5)) {
			System.out.print("; " + input2 +"; "+ input5);
		}
		if (sameState(input3, input4)) {
			System.out.print("; " + input3 +"; "+ input4);
		}
		if (sameState(input3, input5)) {
			System.out.print("; " + input3 +"; "+ input5);
		}
		if (sameState(input4, input5)) {
			System.out.print("; " + input4 +"; "+ input5);
		}	
	}
}