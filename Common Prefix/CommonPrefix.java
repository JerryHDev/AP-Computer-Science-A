// Jerry Huang
// Period 2
// APCS
// Common Prefix HW

import java.util.Scanner;

public class CommonPrefix {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first string: ");
		String string1 = input.nextLine();
		System.out.print("Enter second string: ");
		String string2 = input.nextLine();
		
		System.out.printf("\nFind the common prefix of %s and %s...", string1, string2);
		
		commonPrefix(string1, string2);
	}
	
	
	/**
	 * Finds common prefix of two strings
	 * @param string1
	 * @param string2
	 */
	public static void commonPrefix(String string1, String string2) {
		
		// String to hold common prefix
		String retval = "";
		
		int length = Math.min(string1.length(), string2.length()); // finds the shortest of the two strings
		
		for (int i = 0; i < length; i++) {
			
			// Checks if prefixes match
			if (string1.substring(i, i + 1).equals(string2.substring(i, i + 1))) { 
				
				retval += string1.substring(i, i + 1);
			}
			else break;
		}
		
		System.out.printf("\nThe common prefix is: %s", retval);
	}
}