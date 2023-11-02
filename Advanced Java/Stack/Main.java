import java.util.Stack;
class StackDemo { // class Main {
	public static void main(String[] args) {
		/*
		 * Switch back and forth between the below 2 lines (by uncommenting
one of them only) to test and compare your MyStack class with the original
Stack in java.
		 */
		MyStack myStack = new MyStack();
		// MyStack myStack = new MyStack();
		myStack.add(1);
		myStack.add(2);
		myStack.add(3);
		myStack.add(4);
		myStack.add(5);
		
		System.out.println(myStack);
		int topOfStack = (int) myStack.peek();
		System.out.println("Top = " + topOfStack);
		System.out.println(myStack);
		
		topOfStack = (int) myStack.pop();
		System.out.println("Top = " + topOfStack);
		System.out.println(myStack);
		
		myStack.push(5);
		System.out.println(myStack);
	}
}