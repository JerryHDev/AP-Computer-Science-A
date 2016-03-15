/*
 * Jerry Huang
 * 
 * Main Class to test Hamiltonian and TSP classes.
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Create set of random points
		MyPoint[] points = {new MyPoint(10, 5), new MyPoint(3, 8), new MyPoint(23, 39), new MyPoint(8, 11), new MyPoint(16, 19)};
		
		
		// Creates Hamiltonian object
		Hamiltonian hamiltonian = new Hamiltonian();
		
		// If there is a Hamiltonian path through the points
		if (hamiltonian.hasPath(points)) {
			
			hamiltonian.getPath(points); // Get the Hamiltonian path through the points
		}
	}
}
