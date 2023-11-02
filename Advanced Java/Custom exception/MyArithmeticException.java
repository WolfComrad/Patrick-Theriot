class MyArithmeticException extends RuntimeException {
	String msg;
	MyArithmeticException(String s) {
		this.msg = s;
	}
	
	public String toString() {
		return "MyArithmeticException[" + this.msg + "]";
	}
}