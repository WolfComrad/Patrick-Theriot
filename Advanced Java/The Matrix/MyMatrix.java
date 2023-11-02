public class MyMatrix {
	
	double[][] matrix;
	int arraySize;
	
	MyMatrix(double[][] array , int size) {
		
		matrix = array;
		arraySize = size;
	}
	
	public void printMe() {
		
		for (int x = 0; x < arraySize; x++) {
			 for (int y = 0; y < arraySize; y++) {
				 System.out.print(matrix[x][y] + " ");
			 }
			 System.out.println();
		}
	}
	
	public double getDeterminant() {
		
		double determinant = 0.0;
		
		// getting the determinant for a 2by2
		if (arraySize == 2) {
			determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
			return determinant;
		}
		// getting the determinant for a 3by3
		else {
			determinant = ((matrix[0][0] * matrix[1][1] * matrix[2][2]) + (matrix[0][1] * matrix[1][2] * matrix[2][0]) + 
					(matrix[0][2] * matrix[1][0] * matrix[2][1]) - (matrix[0][2] * matrix[1][1] * matrix[2][0]) - 
					(matrix[0][1] * matrix[1][0] * matrix[2][2]) - (matrix[0][0] * matrix[1][2] * matrix[2][1]));
			return determinant;
		}			 
	}
}