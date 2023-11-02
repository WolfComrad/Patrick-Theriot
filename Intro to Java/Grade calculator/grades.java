/* CMPS 161, Patrick Theriot, W0702809.
 * 
 * this program takes 7 grades the user inputs and then prints
 * out the grades, average grade, the highest and lowest grades,
 * prints out "perfect score" if one of the scores is 100%,
 * and prints the median grade.*/

import java.util.Scanner;
public class grades {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int [] grades = new int [7];
		double average;
		
		//this loop takes the user inputs and stores them in grades[].
		for(int i = 0; i < grades.length; i++) {
			System.out.print("Grade " + (i + 1) + ": ");
			grades[i] = input.nextInt();
		}
		
		//this prints out the users grades.
		System.out.print("\nGrades: ");
		printArray(grades);
		
		//this loop calculates the average.
		double sum =0;
		for(int k = 0; k < grades.length; k++) {
			sum = sum + grades[k];
		}
		average = sum / grades.length;
		System.out.print("\n\nAverage: " + average);
		
		//this calls upon the sort method and then prints out the highest number and lowest number.
		int[] sorted = sort(grades);
		System.out.println("\n\nHighest: " + sorted[6] + " Lowest: " + sorted[0]);
		
		//this calls upon the checkPerfect method and finds out if its true.
		boolean perfect = checkPerfect(grades);
		if (perfect == true) {
			System.out.println("\nPERFECT SCORE");
		}
		
		//this prints out the middle number of sorted[].
		System.out.println("\nMedian: " + sorted[3]);
	}

	//this is the printArray method.
	private static void printArray(int[] a) {
		
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				System.out.print(a[i]);
			}
			else {
				System.out.print(", " + a[i]);
			}
		}
	}

	//this is the checkPerfect method and it checks to see if one of the user inputs is = 100.
	private static boolean checkPerfect(int[] a) {
		
		for(int i = 0; i < a.length; i++) {
			if (a[i] == 100) {
				return true;
			}
			continue;
		}
		return false;
	}
		
	//this is the sort method and it sorts the grades array.
	private static int[] sort(int[] a) {
		
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		
		return a;
	}
}