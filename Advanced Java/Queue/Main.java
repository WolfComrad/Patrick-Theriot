public class Main {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue);
		queue.add(4);
		queue.add(5);
		System.out.println(queue);
		
		int b = (int)queue.peek();
		System.out.println(b);
		
		int a = (int)queue.poll();
		System.out.println(queue);
		System.out.println(a);
		
		queue.push(99);
		queue.add(6);
		System.out.println(queue);
		
		int c = (int)queue.peekLast();
		System.out.println(c);
		
		c = (int)queue.pollLast();
		System.out.println(queue);
		System.out.println(c);
	}
}
