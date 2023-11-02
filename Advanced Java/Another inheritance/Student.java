class Student extends Person{
	private int[] grades;
	
	Student(String name, int ssn) {
		super(name, ssn);
		this.grades = new int[3];
	}
	
	@Override
	public String toString() {
		return name + ":" + ssn;
	}
}