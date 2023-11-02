class uselessDivider {
	public double divider(double numerator, double denominator) throws MyArithmeticException {
		if (denominator == 0.0) {
			throw new MyArithmeticException("Bruh, you can't divide by zero!");
		}
		return numerator / denominator;
	}
	
	public double divider(int numerator, int denominator) throws MyArithmeticException {
		if (denominator == 0) {
			throw new MyArithmeticException("Bruh, you can't divide by zero! int");
		}
		return numerator / denominator;
	}
}