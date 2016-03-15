/*
 * Jerry Huang
 * APCS
 * Per. 2
 * 
 * Hamiltonian implementation.
 * 
 * Problem:
 * Given a TSP oracle and an unordered collection of two dimensional points (myPoint instance) 
 * return a Hamiltonian path *using the TSP* you may not solve the Hamiltonian path problem without using TSP.
 */
public class Hamiltonian {
	
	
	// Empty constructor
	public Hamiltonian() {
	}
	
	
	/**
	 * Checks if there is a Hamiltonian path through the set of points using TSP.
	 * 
	 * @param points to be in Hamiltonian path
	 * @return whether there is a path or not
	 */
	public boolean hasPath(MyPoint[] points) {
		return new TSP().hasPath(points);
	}
	
	
	/**
	 * Returns the Hamiltonian path through the set of points using TSP.
	 * 
	 * @param points to be in Hamiltonian path
	 * @return Hamiltonian path containing points
	 */
	public MyPoint[] getPath(MyPoint[] points) {
		return new TSP().getPath(points);
	}

}
