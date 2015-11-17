/** Jerry Huang
 * APCS, Period 2
 * Kuszmaul
 * Exercise 1.12 from:
 * http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_sec_1.2
 */

public class Ch1_12 {
	
	/**
     * Main function
     * Tests recursive function
     */
	public static void main(String[] args) {
		System.out.println("Element at 6th row and 3nd column of Pascal's triangle is: " + pascal (6, 3));
	}
	
	/**
	 * Computes elements of Pascal's triangle
	 * by means of a recursive process
	 * @param row
	 * @param col: column
	 * @return element of Pascal's triangle
	 */
	public static int pascal(int row, int col) {
		
		// nth row contains exactly n columns. Row cannot be less than column
		if (row < col) {
			System.out.println("Invalid call. Row cannot be less than column!");
			return 0;
		}
		
		// Numbers at edge of triangle are all 1
		else if (col == 0 || row == col) return 1;
		
		// Recursive call
		return pascal(row - 1, col) + pascal(row - 1, col - 1);
	}
}