
/**
 * Jerry Huang
 * 
 * Matrix Class
 * 
 * A matrix object has the properties rows and columns which define the size of the matrix.
 * Each matrix object is created using a 2D array.
 * 
 * 
 * @author Jerry
 *
 */
public class Matrix {
	
	// Size of matrix
	private int rows;
	private int columns;
	
	// Determines size of matrix object
	private int[][] matrix;
	
	// No-arg constructor
	public Matrix() {
	}
	
	// Arg-constructor
	public Matrix(int[][] matrix) {
		this.matrix = matrix;
		this.rows = matrix.length;
		this.columns = matrix[0].length;
	}
	
	
	/**
	 * Getter and setter methods
	 */
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
		this.rows = matrix.length;
		this.columns = matrix[0].length;
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public int getValueAt(int j, int k) {
		return matrix[j][k];
	}
	
	
	/**
	 * Prints the current matrix
	 */
	public void printMatrix() {
		
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				System.out.print(matrix[i][k] + " ");
			}
			System.out.println("\n");
		}
	}
	
	
	/**
	 * Multiplies the current matrix object with the parameter matrix object
	 * 
	 * @param matrix of type Matrix
	 * @return retval matrix object of type Matrix
	 */
	public Matrix multiplyWith(Matrix matrix) {
		
		int rows = this.rows;
		int columns = matrix.getColumns();
		
		int[][] retval = new int[rows][columns];
		int sum = 0;
		
		if (this.columns == matrix.getRows()) {
			
			// Multiply the two matrices
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {
					
					for (int i = 0; i < this.columns; i++) {
						int ans = this.matrix[j][i] * matrix.getValueAt(i, k);
						sum += ans;
					}
					
					retval[j][k] = sum;
					sum = 0;
				}
			}
		}
		else
			System.out.println("Error! These two matrices cannot be multiplied!");
		
		return new Matrix(retval);
	}
	
	
	/**
	 * Performs scalar multiplication on the current matrix object
	 * @param scale
	 * @return retval matrix object of type Matrix
	 */
	public int[][] scalarBy(int scale) {
		
		int[][] retval = new int[rows][columns];
		
		for (int j = 0; j < rows; j++) {
			for (int k = 0; k < rows; k++) {
				retval[j][k] = matrix[j][k] * scale;
			}
		}
		return retval;
	}
}