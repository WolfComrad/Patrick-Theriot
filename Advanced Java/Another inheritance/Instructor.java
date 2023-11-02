class Instructor extends Person {
	private String office;
	
	Instructor(String name, int ssn, String office) {
		super(name, ssn);
		this.office = office;
	}
	
	public String toString() {
		return name + ":" + ssn + ":" + office;
	}
}