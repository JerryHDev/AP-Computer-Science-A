import java.util.Scanner;


/**
 * Broken Toaster Class
 * 
 * Assignment:
 * 
 * We want to give broken toasters to the Engineering tech class which they can fix 
 * to practice their troubleshooting skills. Your job is to design an object (BrokenToaster) 
 * which can be diagnosed by a user to figure out what is wrong with it based on inputs and behaviors.
 * 
 * Naturally you could just have a toaster that never works and the fix is to replace it. 
 * 
 * Try for something more interesting. Use logic.
 * 
 * 
 * @author Jerry
 *
 */
public class BrokenToaster {
	
	private boolean pluggedIn = true;
	private boolean powerCordBroken = false;
	private boolean toasterBroken = false;
	private String temperature = "just right";
	private String orientation = "right side up";
	private String size = "regular sized";
	private int slots = 2;
	
	
	// Keeps track of which attribute of the toaster needs to be diagnosed
	private int faultyAttribute = -1;
	
	// No-arg constructor
	public BrokenToaster() {
		
		// Randomly choose an attribute of toaster to be wrong
		int num = 1 + (int)(Math.random() * 7);
		
		switch(num) {
		case 1:
			pluggedIn = false;
			faultyAttribute = 1;
			break;
		case 2:
			powerCordBroken = true;
			faultyAttribute = 2;
			break;
		case 3:
			toasterBroken = true;
			faultyAttribute = 3;
			break;
		case 4:
			temperature = "on fire";
			faultyAttribute = 4;
			break;
		case 5:
			temperature = "cold";
			faultyAttribute = 4;
			break;
		case 6:
			orientation = "sideways";
			faultyAttribute = 5;
			break;
		case 7:
			size = "too small and toast cannot fit in it";
			faultyAttribute = 6;
			break;
		case 8:
			slots = 0;
			faultyAttribute = 7;
			break;
		}
	}
	
	public void diagnoseToaster() {
		
		Scanner input = new Scanner(System.in);
		
		// Display intro
		System.out.println("Welcome to the broken toaster.");
		System.out.println("Something is wrong with it and we need your help to diagnose it!");
		System.out.println("\nWhat do you want to check?");
		System.out.println("(1) Plugged in? | (2) Is the power cord broken");
		System.out.println("(3) Is the toaster broken | (4) Temperature");
		System.out.println("(5) Orientation | (6) Size | (7) Slots");
		System.out.println("(8) I've found what's wrong with the toaster!");
		
		int choice = input.nextInt();
		
		// Checks the specific attribute of the toaster 
		while (choice != 8) {
			
			switch (choice) {
			case 1: 
				if (pluggedIn) {
					System.out.println("The toaster is plugged in");
				}
				else
					System.out.println("The toaster is not plugged in");
				break;
			case 2:
				if (powerCordBroken) {
					System.out.println("The power cord is broken");
				}
				else
					System.out.println("The power cord is not broken");
				break;
			case 3:
				if (toasterBroken) 
					System.out.println("The toaster is broken. Fix it now or no toast for you!");
				else
					System.out.println("The toast is not broken");
				break;
			case 4:
				System.out.println("The toaster temperature is " + temperature);
				break;
			case 5:
				System.out.println("The toaster is " + orientation);
				break;
			case 6:
				System.out.println("The toaster is " + size);
				break;
			case 7:
				System.out.println("The toaster has " + slots + " slot(s) for toasting");
				break;
			}
			
			System.out.println("\nWhat do you want to check?");
			System.out.println("(1) Plugged in? | (2) Is the power cord broken");
			System.out.println("(3) Is the toaster broken | (4) Temperature");
			System.out.println("(5) Orientation | (6) Size | (7) Slots");
			System.out.println("(8) I've found what's wrong with the toaster!");
			choice = input.nextInt();
		}
		
		// When user enters 8, they assume they know how to diagnose the toaster
		System.out.println("\nSelect the diagnosis for the toaster: ");
		System.out.println("(1) Not plugged in | (2) Power cord is broken");
		System.out.println("(3) Toaster is broken | (4) Temperature is not right");
		System.out.println("(5) Orientation is wrong | (6) Size is wrong");
		System.out.println("(7) Not enough slots for toast");
		
		int answer = input.nextInt();
		
		// Checks if diagnosis is right
		if (answer == faultyAttribute) {
			System.out.println("Congradulations! You correctly diagnosed the toaster!");
		}
		else {
			System.out.println("Sorry! That is the improper diagnosis for the toaster. Try again!");
		}		
	}
}