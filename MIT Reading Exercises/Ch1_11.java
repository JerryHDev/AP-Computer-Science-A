/** Jerry Huang
 * APCS, Period 2
 * Kuszmaul
 * Exercise 1.11 from:
 * http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_sec_1.2
 */

public class Ch1_11 {

    /**
     * Main function
     * Tests recursive and iterative functions
     */
    public static void main(String args[]) {
        System.out.println("Recursive function answer: " + recursiveFunction(7));
        System.out.println("Recursive function answer: " + iterativeFunction(7));
    }

    /**
     * Computes f(n) by means of an recursive process.
     * f(n) defined by function:
     *  f(n) = n if n<3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n>3.
     * @param n, the value to compute
     * @return f(n)
     */
    public static int recursiveFunction(int n) {
        if (n < 3) return n;
        
        // Recursive call
        return (recursiveFunction(n - 1) + 2 * recursiveFunction(n - 2) + 3 * recursiveFunction(n - 3));
    }

    /**
     * Computes f(n) by means of an recursive process.
     * f(n) defined by function: 
     * f(n) = n if n<=3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n>3
     * @param n: value to be computed
     * @return f(n)
     */
    public static int iterativeFunction(int n) {
        if (n < 3) return n;

        // Values of f(n-1), f(n-2), and f(n-3)
        int num1 = 0;
        int num2 = 1;
        int num3 = 2;

        int temp = 0; // Temporary value
        
        for (int i = 3; i <= n; i++) {
        	
        	// Sets temporary value
            temp = num2 + 2 * num2 + 3 * num1;

            // Resetting 3 values
            num1 = num2;
            num2 = num3;
            num3 = temp;
        }
        
        return num3;
   }
}