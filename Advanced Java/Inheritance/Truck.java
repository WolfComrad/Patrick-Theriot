class Truck extends Car{
	public void method() {
		//super.method();
		System.out.println("this method is in class Truck");
	}
	
	public void method(int number) {
		System.out.println("this method is the overload(int) method: " + number);
	}
}