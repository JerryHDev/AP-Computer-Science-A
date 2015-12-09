// Jerry Huang
// Period 2
// APCS
// Randp Project

/**
 * Randp Program
 * 
 * Main Class
 * For testing Randp
 * 
 * @author Jerry
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Creates Randp object for testing
		Randp rand = new Randp(6);
		
		// Prints out the randomly selected values
		for (int i = 0; i < 9; i++) {
			System.out.println(rand.nextInt());
		}
	}
}
