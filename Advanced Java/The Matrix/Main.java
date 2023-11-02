class Main {
	public static void main(String[] args) {
		
		// 2 by 2
		double[][] table = {{1, 2},{2, 3}};
		
		MyMatrix determinant = new MyMatrix(table, 2);
		
		determinant.printMe();
		
		System.out.println("Determinant of matrix a is " + determinant.getDeterminant());
		
		// 3 by 3
		double[][] table3x3 = {{1, 2, 3},{2, 3, 4},{3, 4, 5}};
		
		 MyMatrix b = new MyMatrix(table3x3, 3);
		 
		 b.printMe();
		 
		System.out.println("Determinant of matrix b is " +	b.getDeterminant());
	}
}