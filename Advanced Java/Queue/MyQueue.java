public class MyQueue {
	// internally we need some sort of basic collection, an array.
	// everything is an object, we wont use generics.
	private Object[] list;
	// arrays are fixed in size, we need to keep track of the virtual size of the queue, not the array.
	private int size;
	
	MyQueue() {
		this.size = 0;
		// inital size is arditrary, will need to take it in consideration later.
		this.list = new Object[1];
	}
	
	// add an element to the queue
	public void add(Object o) {
		// indexes start at 0, size reflects the "next available index" in the array.
		this.list[this.size] = o;
		// sence we added an element, we need to keep track with the size attribute.
		this.size++;
		// PROBLEM! this.list might be full at this point meaning we wont be able to add another
		// element. We have to fix this by creating a new, larger array, and replaceing the old with the new:
		
		if (this.size == this.list.length) { // checks if the size
			//variable reached the capacity of the array
			Object[] newArray = new Object[2 * this.size]; /* again,
			arbitrary value here. keep in mind this whole process is
			expensive for the computer: you dont want to increase all the
			time, but also what you dont want to create are gigantic array that consumes too much space in memory.*/
			
			//copy values from old array to new
			for (int i = 0; i < this.list.length; i++) {
				newArray[i] = this.list[i];
			}
			
			// finally, replace old with new array
			this.list = newArray;
		}
	}
	
	//peeking does not change the queue state
	public Object peek() {
		//... so we can simply return the front of the line
		return this.list[0];//which is always going to be at index 0.
	}
	
	//poll() removes and returns the item in front of the line.
	public Object poll() {
		//need to remove the front of the line in this case.
		Object frontOfLine = this.list[0]; // save it in a variable so we dont lose reference to it.
		
		//no need to loop over all elements in the array, only the ones
		//with elements added to it.
		for (int i = 1; i < this.size; i++) {
			this.list[i - 1] = this.list[i]; //shift the slot of elements by 1
		}
		
		this.size--;//since we are removing, need to keep track of the size
		
		return frontOfLine;// return the variable we saved
	}
	
	//push
	public void push(Object o) {
		Object[] newArray = new Object[this.list.length + this.size];
		newArray[0] = o;
		
		for (int i = 0; i < this.size; i++) {
			newArray[i+1] = this.list[i];
		}
		this.list = newArray;
	}
	
	//peekLats
	public Object peekLast() {
		return this.list[this.size - 1];
	}
	
	//pollLast
	public Object pollLast() {
		Object o = this.list[this.size - 1];
		
		this.list[this.size - 1] = null;
		this.size--;
		return o;
	}
	
	// tostring to print this object nicely
	public String toString() {
		String s = "[";
		for (int i = 0; i < this.size; i++) {
			Object o = this.list[i];
			s = s + o.toString() + ", ";
		}
		s = s + "]";
		return s;
	}
}