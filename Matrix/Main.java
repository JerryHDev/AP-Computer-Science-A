/**
 * Jerry Huang
 * 
 * Main Class
 * Used to test the Matrix class and its methods.
 * 
 * 
 * @author Jerry
 *
 */
public class Main {

	public static void main(String[] args) {
		
		int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] array2 = {{7, 8}, {9, 10}, {11, 12}};
		
		// Creates 2 matrix objects from above 2D arrays
		Matrix matrix1 = new Matrix(array1);
		Matrix matrix2 = new Matrix(array2);
		
		matrix1.printMatrix();
		System.out.println("times\n");
		matrix2.printMatrix();
		System.out.println("equals\n");
		
		
		/* Result matrix is equal to matrix1 dot product matrix 2 */
		Matrix result = matrix1.multiplyWith(matrix2);
		
		// Prints result matrix
		result.printMatrix();
	}
}