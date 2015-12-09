import java.util.ArrayList;

// Jerry Huang
// Period 2
// APCS
// Randp HW Assignment

/**
 * Randp Program
 * 
 * A Randp program that produces a random number between 1 and a specified number.
 * This program keeps track of which numbers have already been selected so that there
 * would be no repeats.
 * 
 * @author Jerry
 */
public class Randp {
	
	// Initializes variables and arrays
	ArrayList<Integer> listOfNums = new ArrayList<Integer>();
	private int numsLeft; // Keeps track of the number of unselected numbers
	
	
	/**
	 * Arg constructor 
	 * @param max; numbers will be picked randomly from 1 to max
	 */
	public Randp(int max) {
		
		numsLeft = max;
		
		for (int i = 1; i <= max; i++) {
			
			// Adds all numbers to array list
			listOfNums.add(i);
		}
	}
	
	/**
	 * Once called, returns a randomly selected number between 1 and the max
	 * @return num
	 */
	public int nextInt() {
		
		if (numsLeft != 0) {
			
			// Generate a random index
			int randIndex =  (int)(Math.random() * numsLeft);
			numsLeft--;
			
			// Get the number at the index, then removes the number from the array
			int retval = listOfNums.get(randIndex);
			listOfNums.remove(randIndex);
			
			// Return number
			return retval;
		}
		
		return 0;
	}
}