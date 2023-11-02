/*Patrick Theriot, W0702809, CMPS161-04, 10/14/2020
  
  This program will allow a user to play Rock-paper-scissors-lizard-Spock
  as many times as they wish and it will calculate how many times they win, lose, and tie.*/

import java.util.Scanner;
public class rpsls {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int answer = 1;
		int win = 0;
		int lose = 0;
		int tied = 0;
		
		//This while loop is what keeps the game going as long as the user wants
		while (answer != 0) {
			System.out.println("\nROCK  PAPER  SCISSORS  LIZARD  SPOCK");
			System.out.println("(1)    (2)     (3)      (4)     (5)");
			System.out.print("Enter your choice, or 0 to end:");
			answer = input.nextInt();
			
			//random number 0-4
			int cpuAttack = (int) (Math.random() * 5);
			
			//the rest of these if and else if determine what the results are.
			//these first five ifs determine the outcome if the user chooses 1/Rock. 
			if (answer == 1 && cpuAttack == 0) {
				System.out.println("You showed Rock \nComputer showed Rock "
						+ "\n This results in a tie.");
				tied++;
			}
			else if (answer == 1 && cpuAttack == 1) {
				System.out.println("You showed Rock \nComputer showed Paper "
						+ "\nPaper covers rock \nYou lose.");
				lose++;
			}
			else if (answer == 1 && cpuAttack == 2) {
				System.out.println("You showed Rock \nComputer showed Scissors "
						+ "\nRock crushes scissors \nYou win!");
				win++;
			}
			else if (answer == 1 && cpuAttack == 3) {
				System.out.println("You showed Rock \nComputer showed Lizard "
						+ "\nRock crushes lizard \nYou win!");
				win++;
			}
			else if (answer == 1 && cpuAttack == 4) {
				System.out.println("You showed Rock \nComputer showed Spock "
						+ "\nSpock vaporizes rock \nYou lose.");
				lose++;
			}
			//these next five ifs determine the outcome if the user chooses 2/Paper.
			else if (answer == 2 && cpuAttack == 0) {
				System.out.println("You showed Paper \nComputer showed Rock "
						+ "\nPaper covers rock \nYou win!");
				win++;
			}
			else if (answer == 2 && cpuAttack == 1) {
				System.out.println("You showed Paper \nComputer showed Paper "
						+ "\nThis results in a tie.");
				tied++;
			}
			else if (answer == 2 && cpuAttack == 2) {
				System.out.println("You showed Paper \nComputer showed Scissors "
						+ "\nScissors cuts paper \nYou lose.");
				lose++;
			}
			else if (answer == 2 && cpuAttack == 3) {
				System.out.println("You showed Paper \nComputer showed Lizard "
						+ "\nLizard eats paper \nYou lose.");
				lose++;
			}
			else if (answer == 2 && cpuAttack == 4) {
				System.out.println("You showed Paper \nComputer showed Spock "
						+ "\nPaper disproves Spock \nYou win!");
				win++;
			}
			//these next five ifs determine the outcome if the user chooses 3/Scissors.
			else if (answer == 3 && cpuAttack == 0) {
				System.out.println("You showed Scissors \nComputer showed Rock "
						+ "\nRock crushes scissors \nYou lose.");
				lose++;
			}
			else if (answer == 3 && cpuAttack == 1) {
				System.out.println("You showed Scissors \nComputer showed Paper "
						+ "\nScissors cuts paper \nYou win!");
				win++;
			}
			else if (answer == 3 && cpuAttack == 2) {
				System.out.println("You showed Scissors \nComputer showed Scissors "
						+ "\nThis results in a tie.");
				tied++;
			}
			else if (answer == 3 && cpuAttack == 3) {
				System.out.println("You showed Scissors \nComputer showed Lizard "
						+ "\nScissors decapitates lizard \nYou win!");
				win++;
			}
			else if (answer == 3 && cpuAttack == 4) {
				System.out.println("You showed Scissors \nComputer showed Spock "
						+ "\nSpock smashes scissors \nYou lose.");
				lose++;
			}
			//these next five ifs determine the outcome if the user chooses 4/Lizard.
			else if (answer == 4 && cpuAttack == 0) {
				System.out.println("You showed Lizard \nComputer showed Rock "
						+ "\nRock crushes lizard \nYou lose.");
				lose++;
			}
			else if (answer == 4 && cpuAttack == 1) {
				System.out.println("You showed Lizard \nComputer showed Paper "
						+ "\nLizard eats paper \nYou win!");
				win++;
			}
			else if (answer == 4 && cpuAttack == 2) {
				System.out.println("You showed Lizard \nComputer showed Scissors "
						+ "\nScissors decapitates lizard \nYou lose.");
				lose++;
			}
			else if (answer == 4 && cpuAttack == 3) {
				System.out.println("You showed Lizard \nComputer showed Lizard "
						+ "\nThis results in a tie.");
				tied++;
			}
			else if (answer == 4 && cpuAttack == 4) {
				System.out.println("You showed Lizard \nComputer showed Spock "
						+ "\nLizard poisons Spock \nYou win!");
				win++;
			}
			//these next five ifs determine the outcome if the user chooses 5/Spock.
			else if (answer == 5 && cpuAttack == 0) {
				System.out.println("You showed Spock \nComputer showed Rock "
						+ "\nSpock vaporizes rock \nYou win!");
				win++;
			}
			else if (answer == 5 && cpuAttack == 1) {
				System.out.println("You showed Spock \nComputer showed Paper "
						+ "\nPaper disproves Spock \nYou lose.");
				lose++;
			}
			else if (answer == 5 && cpuAttack == 2) {
				System.out.println("You showed Spock \nComputer showed Scissors "
						+ "\nSpock smashes scissors \nYou win!");
				win++;
			}	
			else if (answer == 5 && cpuAttack == 3) {
				System.out.println("You showed Spock \nComputer showed Lizard "
						+ "\nLizard poisons Spock \nYou lose.");
				lose++;
			}
			else if (answer == 5 && cpuAttack == 4) {
				System.out.println("You showed Spock \nComputer showed Spock "
						+ "\nThis results in a tie.");
				tied++;
			}
			//this statement tells the user that they plugged in an option thats not compatible.
			else {
				System.out.println("You have put in an answer that is not an option.");
			}
		}
		
		//End of game results
		System.out.println("\nYou won " + win + " games, tied " + tied + 
				" games, and lost " + lose + " games.");
	}
}