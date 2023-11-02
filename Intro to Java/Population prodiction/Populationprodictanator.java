//Patrick Theriot, w0702809, CMPS 161-04.
// August 2, 2020			Assignment #1

//First homework assignment that predicts the human population for five years. No leap years.

//1 birth every 12 seconds.
//1 death every 15 seconds.
//1 new immigrant every 2 minutes.

//Class name + Ghost square + Scanner input.
import java.util.Scanner;
public class Populationprodictanator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//this figures out how many seconds are in a year.
		int secondsInYear = 60 * 60 *24 * 365;
		
		//this figures out the population change in a year.
		int birthsInYear = secondsInYear / 12;		
		int deathsInYear = secondsInYear / 15;
		int newImmigrent = secondsInYear / (60 * 2);
		int populationChangeInYear = birthsInYear + newImmigrent - deathsInYear;
		
		//this prints the starting population.
		System.out.print("Starting population: ");
		int population = input.nextInt();
		
		//prints year one's population.
		int yearOne = populationChangeInYear + population; 
		System.out.println("After one year: " + yearOne);
		
		//prints year two's population.
		int yearTwo = populationChangeInYear + yearOne; 
		System.out.println("After two years: " + yearTwo);
		
		//prints year three's population.
		int yearThree = populationChangeInYear + yearTwo;
		System.out.println("After three years: " + yearThree);
		
		//prints year four's population.
		int yearFour = populationChangeInYear + yearThree;
		System.out.println("After four years: " + yearFour);
		
		//prints year five's population.
		int yearFive = populationChangeInYear + yearFour;
		System.out.println("After five years: " + yearFive);
		
	}
}