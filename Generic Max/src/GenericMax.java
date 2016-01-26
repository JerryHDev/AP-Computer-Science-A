import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Jerry Huang
// Period 2
// APCS
// Generic Max Assignment


public class GenericMax {
	
	/**
	 * Finds the maximum of a collection of values
	 * 
	 * @param collection of values
	 * @return maximum value
	 */
	public static <T extends Comparable<T>> T maximum(Collection<T> parameters) {
		
		Iterator<T> iterator = parameters.iterator(); // iterator used to iterate through collection of values
		T max = iterator.next();
		
		while (iterator.hasNext()) {
			
			T next = iterator.next();
			
			if (max.compareTo(next) < 0) {
				max = next;
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		
		// Creates 3 lists of different types of values
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(16);
		ints.add(17);
		ints.add(18);
		ArrayList<Double> doubles = new ArrayList<Double>();
		doubles.add(1.6);
		doubles.add(7.5);
		doubles.add(3.9);
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("computer");
		strings.add("book");
		strings.add("phone");
		
		
		// Set up some test cases
		System.out.printf("The maximum of %d, %d, and %d is: %d", 16, 17, 18, maximum(ints));
		System.out.printf("\nThe maximum of %.1f, %.1f, and %.1f is: %.1f", 1.6, 7.5, 3.9, maximum(doubles));
		System.out.printf("\nThe maximum of %s, %s, and %s is: %s", "computer", "book", "phone", maximum(strings));
		
	}
}
