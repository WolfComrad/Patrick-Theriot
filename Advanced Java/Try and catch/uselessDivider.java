class uselessDivider {
	public double divider(double numerator, double denominator) throws ArithmeticException {
		if (denominator == 0.0) {
			throw new ArithmeticException("Bruh, you can't divide by zero!");
		}
		return numerator / denominator;
	}
	
	public double divider(int numerator, int denominator) throws ArithmeticException {
		if (denominator == 0) {
			throw new ArithmeticException("Bruh, you can't divide by zero! int");
		}
		return numerator / denominator;
	}
}