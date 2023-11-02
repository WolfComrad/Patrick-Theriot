public class RecursiveMethods {
	public static int sum(int n) {
		//base case
		if (n==0) {
			return 0;
		}
		
		//general case
		return n + sum(n-1);
	}
	public static int findMin(int a[]) {
		//base case
		if (a.length == 1) {
			return a[0];
		}
		
		//general case
		int[] b = new int[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			b[i - 1] = a[i];
		}
		
		int minB = findMin(b);
		if (a[0] < minB) {
			return a[0];
		}
		
		return minB;
	}
	
	public static int[] reverse(int[] a) {
		//base case
		if (a.length <= 1) {
			return a;
		}
		
		//general case
		int length = a.length;
		int first = a[0];
		a[0] = a[length - 1];
		a[length - 1] = first;
		int[] b = new int[a.length - 2];
		for (int i = 1; i < a.length - 1; i++) {
			b[i - 1] = a[i];
		}		
		b = reverse(b);
		for (int i = 0; i < b.length; i++) {
			a[i + 1] = b[i];
		}
		return a;		
	}
	
	public static boolean isPalindrome(char a[]) {
		//base case
		if (a.length == 1) {
			return true;
		}
		else if (a.length == 2) {
			if (a[0] == a[1]) {
				return true;
			}
			else {
				return false;
			}
		}
		
		//general case
		if (a[0] != a[a.length - 1]) {
			return false;
		}
		char[] b = new char[a.length - 2];
		for (int i = 1; i < a.length - 1; i++) {
			b[i - 1] = a[i];
		}
		return isPalindrome(b);
	}
}