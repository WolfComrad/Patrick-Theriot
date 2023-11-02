public class Main {
	public static void main(String[] args) {
		//Overridding methods
		Car car = new Truck();
		
		car.method();
		
		//Car car = new Car();
		
		/*Sedan civic = new Sedan();
		
		Truck f150 = new Truck();
		
		car.method();
		civic.method();
		f150.method();*/
		
		Truck truck = new Truck();
		truck.method(1);
	}
}