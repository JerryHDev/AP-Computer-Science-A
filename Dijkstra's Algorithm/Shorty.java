import java.util.ArrayList;
import java.util.HashMap;


public interface Shorty {
	
	public HashMap<String, String> path = new HashMap<String, String>();
	
	
	/**
	 * Creates path HashMap which maps each node in the path to it's corresponding pv node.
	 * Then creates an array containing the nodes in the path in order
	 * from the start node to the destination node.
	 * 
	 * @param startNode
	 * @param destNode
	 */
	public static ArrayList next(String destNode, Dijkstra myD) {
		
		String startNode = myD.startNode;
		String currentNode = destNode;
		
		System.out.println("\n\nSHORTEST PATH...:");
		
		// Creates path HashMap
		path.put(currentNode, myD.prev.get(myD.nodes.indexOf(currentNode)));
		System.out.println("\nNode: " + currentNode + " PV: " + myD.prev.get(myD.nodes.indexOf(currentNode)));
		
		while (currentNode != startNode) {
			currentNode = myD.prev.get(myD.nodes.indexOf(currentNode));
			path.put(currentNode, myD.prev.get(myD.nodes.indexOf(currentNode)));
			System.out.println("Node: " + currentNode + " pv: " + myD.prev.get(myD.nodes.indexOf(currentNode)));
		}
		
		currentNode = destNode;
		
		// Create array of nodes in path in reverse order
		ArrayList<String> pathArray = new ArrayList<String>();
		
		for (int i = 0; i < path.size(); i++) {
			pathArray.add(currentNode);
			currentNode = path.get(currentNode);
		}
		
		return reverseOrder(pathArray);
	}
	
	
	/** Reverse the order of the shortest path array */
	public static ArrayList<String> reverseOrder(ArrayList<String> path) {
		
		for (int i = 0; i < path.size() / 2; i++) {
			  String temp = (String) path.get(i);
			  path.set(i, path.get(path.size() - 1- i));
			  path.set(path.size() - 1 - i, temp);
		}
		return path;
	}
}