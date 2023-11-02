import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println(RecursiveMethods.sum(2));
		int[] b = {7,5,89,9,4,1};
		System.out.println(RecursiveMethods.findMin(b));
		char[] a = {'a', 'b', 'c', 'c', 'l', 'a'};
		System.out.println(RecursiveMethods.isPalindrome(a));
		int[] c = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(RecursiveMethods.reverse(c)));
		
	}
}