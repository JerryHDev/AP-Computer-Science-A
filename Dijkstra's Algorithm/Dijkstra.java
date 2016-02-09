import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;


/*
 * By Jerry Huang.
 * APCS Period 2
 * 
 * 
 * Dijkstra Program Assignment. This program finds the shortest path available from a start
 * node to a destination node.
 * 
 * Instructions:
 * In Java. Implement a class called Dijkstra that has a consturctor method
 * that takes a HashMap that maps a String to a Hashmap that maps Strings to Integers) 
 * which represents an adjacency list representation of a graph, and a String 
 * that represents  a starting node, and produces public variables called path 
 * of type  HashMap (from String to  String)  that represents the sequence of 
 * vertices corresponding to the single source shortest path as discovered by Dijkstra's algorithm.
 * In addition, your work should specify and implement an Interface that requires the method  
 * ArrayList Next( String, Dijkstra)
 * the return value representing the shortest path between the nodes represented by 
 * the argument string and the start node within the graph implicitly represented by the 
 * argument to the constructor of the Dijksta object.
 */

public class Dijkstra {
	
	
	public HashMap<String, String> path;
	
	HashMap<String, HashMap<String, Integer>> nodeDistances;
	
	String startNode = "";
	String destNode = "";
	
	ArrayList<String> nodes;
	ArrayList<Boolean> k; // Boolean values, if a node has been selected yet
	ArrayList<String> pv; // previous node in the shortest path
	ArrayList<Double> dv; // distance to this node from start node
	
	PriorityQueue distancePriorityQueue; // Used to pull the minimum distance available from unselected nodes
	
	public Dijkstra(HashMap<String, HashMap<String, Integer>> nodeDistances, String start, String destination) {
		
		this.nodeDistances = nodeDistances;
		this.startNode = start;
		this.destNode = destination;
		
		initializeVariables(nodeDistances.size());
		runDijkstra(nodeDistances, startNode);
		
		printResults();
		
		createShortestPath();
	}
	
	
	/**
	 * Computes and finds the shortest distance path between nodes.
	 * 
	 * @param nodeDistances: HashMap of node adjacencies and distances
	 * @param selectedNode: Current selected node
	 */
	public void runDijkstra(HashMap<String, HashMap<String, Integer>> nodeDistances, String selectedNode) {
		
		Iterator<String> keySetIterator = nodeDistances.get(selectedNode).keySet().iterator();
		
		String nextNode = "";
		
		while (!allNodesSelected()) {
		
			System.out.println("\nSelected node: " + selectedNode);
			System.out.println("Number of adjacent nodes to " + selectedNode + ": " 
			+ nodeDistances.get(selectedNode).size());
		
			while(keySetIterator.hasNext()) {
				
				nextNode = keySetIterator.next();
				int currentNodeDistance 
				= nodeDistances.get(selectedNode).get(nextNode); // distance from current node to destination node
				
				double accumulatedDistance 
				= currentNodeDistance + dv.get(nodes.indexOf(selectedNode)); // total distance from start node to destination node
				
				if (accumulatedDistance < dv.get(nodes.indexOf(nextNode)) && k.get(nodes.indexOf(nextNode)) == false) {
					dv.set(nodes.indexOf(nextNode), accumulatedDistance);
					pv.set(nodes.indexOf(nextNode), selectedNode);
					distancePriorityQueue.add(accumulatedDistance);
				}
				
				System.out.printf("Adjacent node: %s, dv: %.0f, pv: %s\n", nextNode, 
				dv.get(nodes.indexOf(nextNode)), pv.get(nodes.indexOf(nextNode)));
			}
			
			// Selects new node and iterates through new node adjacencies
			selectedNode = selectMinDistance();
			keySetIterator = nodeDistances.get(selectedNode).keySet().iterator();
		}
	}
	
	
	/**
	 * Selects the minimum distance available from the unselected nodes
	 * and returns the name of the node with the minimum distance.
	 * 
	 * @return minNode: String of minimum distance node
	 */
	public String selectMinDistance() {
		
		double minDistance = (double)distancePriorityQueue.poll();
		String minNode = nodes.get(dv.indexOf(minDistance));
		
		System.out.println("\nMinimum distance node: " + minNode);
		System.out.printf("Minimum distance: %.0f\n", minDistance);
		
		// Select minimum distance node
		k.set(dv.indexOf(minDistance), true);
		
		return minNode;
	}
	
	
	/** Prints the results of the dijkstra's graph */
	public void printResults() {
		System.out.println("\n\nPRINTING THE RESULTS...\n");
		
		for (int i = 0; i < nodes.size(); i++) {
			System.out.println(nodes.get(i) + ": " + k.get(i) + "  " + dv.get(i) + "  " + pv.get(i));
			System.out.println("-------------------");
		}
	}
	
	
	/**
	 * Creates path HashMap which maps each node in the path to it's corresponding pv node.
	 * Then creates an array containing the nodes in the path in order
	 * from the start node to the destination node.
	 * 
	 * @param startNode
	 * @param destNode
	 */
	public void createShortestPath() {
		
		String startNode = this.startNode;
		String destNode = this.destNode;
		
		// Creates path HashMap
		path.put(destNode, pv.get(nodes.indexOf(destNode)));
		System.out.println("Node: " + destNode + " PV: " + pv.get(nodes.indexOf(destNode)));
		
		while (destNode != startNode) {
			destNode = pv.get(nodes.indexOf(destNode));
			path.put(destNode, pv.get(nodes.indexOf(destNode)));
			System.out.println("Node: " + destNode + " pv: " + pv.get(nodes.indexOf(destNode)));
		}
		
		destNode = this.destNode;
		
		// Create array of nodes in path in reverse order
		ArrayList<String> pathArray = new ArrayList<String>();
		for (int i = 0; i < path.size(); i++) {
			pathArray.add(destNode);
			destNode = path.get(destNode);
		}
		
		System.out.println("Array of nodes from start to end IN ORDER: " + reverseOrder(pathArray));
	}
	
	
	/** Reverse the order of the shortest path array */
	public ArrayList<String> reverseOrder(ArrayList<String> path) {
		
		for (int i = 0; i < path.size() / 2; i++) {
			  String temp = (String) path.get(i);
			  path.set(i, path.get(path.size() - 1- i));
			  path.set(path.size() - 1 - i, temp);
		}
		return path;
	}
	
	
	/** Checks if all nodes in the graph have been selected */
	public boolean allNodesSelected() {
		for (int i = 0; i < k.size(); i++) {
			if (k.get(i) == false) {
				return false;
			}
		}
		return true;
	}
	
	
	/** Initializes ArrayLists */
	private void initializeVariables(int size) {
		path = new HashMap<String, String>();
		distancePriorityQueue = new PriorityQueue();
		nodes = new ArrayList<String>();
		k = new ArrayList<Boolean>();
		pv = new ArrayList<String>();
		dv = new ArrayList<Double>();
		nodes.add("A");
		nodes.add("B");
		nodes.add("C");
		nodes.add("D");
		nodes.add("E");
		nodes.add("F");
		nodes.add("G");
		nodes.add("H");
		for (int i = 0; i < size; i++) {
			k.add(i, false);
			pv.add(i, null);
			dv.add(i, Double.POSITIVE_INFINITY);
		}
		
		// Sets start node property
		k.set(nodes.indexOf(startNode), true);
		dv.set(nodes.indexOf(startNode), 0.0);
	}
}