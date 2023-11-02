public class MyStack {
	private int size;
	private Object[] myArray;
	
	MyStack() {
		this.size = 0;
		this.myArray = new Object[1];
	}
	
	public void add(Object o) {
		this.myArray[this.size] = o;
		this.size++;
		
		if (this.size == this.myArray.length) {
			Object[] newArray = new Object[2 * this.size];
			
			for (int i = 0; i < this.myArray.length; i++) {
				newArray[i] = this.myArray[i];
			}
			this.myArray = newArray;
		}
	}
	
	public Object peek() {
		return this.myArray[size - 1];
	}
	
	public Object pop() {
		Object topOfStack = this.myArray[size - 1];
		for (int i = this.size + 1; i < this.size; i++) {
			this.myArray[i - 1] = this.myArray[i]; 
		}
		
		this.size--;
		return topOfStack;
	}
	
	public void push(Object o) {
		add(o);
	}
	
	public String toString() {
		String s = "[";
		for (int i = 0; i < this.size; i++) {
			Object o = this.myArray[i]; 
			s = s + o.toString();
			if (i != this.size - 1) {
				s = s + ", ";
			}
		}	
		s = s + "]";
		return s;
			
	}
}