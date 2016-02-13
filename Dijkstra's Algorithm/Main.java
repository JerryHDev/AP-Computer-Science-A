// Jerry Huang
// Period 2 
// APCS
// Dijkstra's Algorithm

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	// Initialize global HashMaps
	HashMap<String, ArrayList<String>> adjacencies;
	HashMap<String, HashMap<String, Integer>> nodeDistances;
	
	public static void main(String[] args) {
		
		// create graph and HashMapcs
		Main threeNodes = new Main();
		threeNodes.nodeDistances = new HashMap<String, HashMap<String, Integer>>();
		threeNodes.adjacencies = new HashMap<String, ArrayList<String>>();
		
		// Set node adjacencies and puts in HashMap
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("B");
		aList.add("F");
		ArrayList<String> bList = new ArrayList<String>();
		bList.add("C");
		bList.add("E");
		ArrayList<String> cList = new ArrayList<String>();
		cList.add("D");
		ArrayList<String> dList = new ArrayList<String>();
		dList.add("E");
		dList.add("F");
		ArrayList<String> eList = new ArrayList<String>();
		eList.add("D");
		eList.add("G");
		ArrayList<String> fList = new ArrayList<String>();
		fList.add("A");
		fList.add("B");
		fList.add("C");
		fList.add("E");
		ArrayList<String> gList = new ArrayList<String>();
		gList.add("D");
		gList.add("H");
		ArrayList<String> hList = new ArrayList<String>();
		hList.add("A");
		hList.add("B");
		threeNodes.adjacencies.put("A", aList);
		threeNodes.adjacencies.put("B", bList);
		threeNodes.adjacencies.put("C", cList);
		threeNodes.adjacencies.put("D", dList);
		threeNodes.adjacencies.put("E", eList);
		threeNodes.adjacencies.put("F", fList);
		threeNodes.adjacencies.put("G", gList);
		threeNodes.adjacencies.put("H", hList);
		
		
		// Set distance between adjacent nodes and puts in HashMap
		HashMap<String, Integer> aDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> bDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> cDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> dDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> eDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> fDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> gDistances = new HashMap<String, Integer>();
		HashMap<String, Integer> hDistances = new HashMap<String, Integer>();
		aDistances.put("B", 8);
		aDistances.put("F", 10);
		bDistances.put("C", 4);
		bDistances.put("E", 10);
		cDistances.put("D", 3);
		dDistances.put("E", 25);
		dDistances.put("F", 18);
		eDistances.put("D", 9);
		eDistances.put("G", 7);
		fDistances.put("A", 5);
		fDistances.put("B", 7);
		fDistances.put("C", 3);
		fDistances.put("E", 2);
		gDistances.put("D", 2);
		gDistances.put("H", 3);
		hDistances.put("A", 4);
		hDistances.put("B", 9);
		threeNodes.nodeDistances.put("A", aDistances);
		threeNodes.nodeDistances.put("B", bDistances);
		threeNodes.nodeDistances.put("C", cDistances);
		threeNodes.nodeDistances.put("D", dDistances);
		threeNodes.nodeDistances.put("E", eDistances);
		threeNodes.nodeDistances.put("F", fDistances);
		threeNodes.nodeDistances.put("G", gDistances);
		threeNodes.nodeDistances.put("H", hDistances);
		
		
		// Testing the HashMaps and printing all adjacencies
		System.out.println("Node distances from A: " + threeNodes.nodeDistances.get("A"));
		System.out.println("Node distances from B: " + threeNodes.nodeDistances.get("B"));
		System.out.println("Node distances from C: " + threeNodes.nodeDistances.get("C"));
		System.out.println("Node distances from D: " + threeNodes.nodeDistances.get("D"));
		System.out.println("Node distances from E: " + threeNodes.nodeDistances.get("E"));
		System.out.println("Node distances from F: " + threeNodes.nodeDistances.get("F"));
		System.out.println("Node distances from G: " + threeNodes.nodeDistances.get("G"));
		System.out.println("Node distances from H: " + threeNodes.nodeDistances.get("H"));
		
		
		// Initialize Dijkstra object
		String startNode = "C";
		Dijkstra myD = new Dijkstra(threeNodes.nodeDistances, startNode);
		
		
		// Shortest path between nodes represented by the argument string 
		//and the start node within the graph implicitly represented by the 
		//argument to the constructor of the Dijkstra object.
		ArrayList<String> path = Shorty.next("D", myD);
		System.out.println("Shortest path: " + path);
		
	}
}
