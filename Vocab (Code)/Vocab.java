// Jerry Huang
// APCS
// Period 2

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


public class Vocab {

	public static void main(String[] args) {
		
		// Demonstrate string, collection, and graph
		demonstrateAString();
		
		demonstrateACollection();
		
		demonstrateAGraph();
	}
	
	/** Demonstrates definition of a string */
	static void demonstrateAString() {
		
		System.out.println("\nDefine string:");
		System.out.println("This is a string");
		System.out.println("A string is a finite sequence of characters");
		System.out.println("Every string has a unique characteristic: length");
		String testString = "This string";
		System.out.println("Let's find the length of the following string: "  + testString);
		System.out.println("Length = " + testString.length());
	}
	
	
	/** Demonstrates definition of a collection 
	 * @param <E>*/
	static <E> void demonstrateACollection() {
		
		System.out.println("\nDefine collection:");
		
		System.out.println("A collection is a grouping of some variable number of data items");
		
		System.out.println("Creating an array of values...");
		ArrayList<String> array = new ArrayList<String>();
		array.add("dog");
		array.add("cat");
		array.add("horse");
		
		System.out.println("Now adding values to a collection...");
		Collection<E> values = (Collection<E>) array;
		
		System.out.println("Now creating iterator to iterate through collection of values...");
		Iterator<E> iterator = values.iterator();
		
		System.out.println("Printing all the values in the collection in order...");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
	
	/** Demonstrates definition of a graph */
	static void demonstrateAGraph() {
		System.out.println("\nDefine graph:");
		
		System.out.println("A graph is an abstract data type. A graph data structure contains a set of nodes or vertices.");
		System.out.println("An example of a graph would be a HashMap that shows an adjacency list.");
		
		System.out.println("Creating HashMap...");
		HashMap<String, ArrayList<String>> adjacencies = new HashMap<String, ArrayList<String>>();
		
		System.out.println("Adding adjacent nodes to the HashMap...");
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("B");
		aList.add("F");
		ArrayList<String> bList = new ArrayList<String>();
		bList.add("C");
		bList.add("E");
		adjacencies.put("A", aList);
		adjacencies.put("B", bList);
		
		System.out.println("Now printing out the adjacency list...");
		System.out.println("A adjacencies: " + adjacencies.get("A"));
		System.out.println("B adjacencies: " + adjacencies.get("B"));
	}

}
