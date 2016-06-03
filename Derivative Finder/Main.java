import java.util.ArrayList;
import java.util.Scanner;



/*
 * Coded by Jerry Huang
 * 5/6/16
 * 
 * Main Class to test Polynomial objects
 * 
 * Creates an object of type Polynomial, prints the polynomial, 
 * then tests the derivative function of the Polynomial class and 
 * prints the new derivative function.
 * 
 */
public class Main {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Create a function
		createPolynomial();
		
	}
	
	
	public static void createPolynomial() {
		
		System.out.print("Terms in polynomial: ");
		
		int terms = input.nextInt();
		ArrayList<String> signs = new ArrayList<String>();
		ArrayList<Double> coefficients = new ArrayList<Double>();
		ArrayList<Integer> exponents = new ArrayList<Integer>();
		
		
		for (int i = 0; i < terms; i++) {
			
			System.out.print("Sign of term " + (i + 1) + ": ");
			signs.add(input.next());
			
			System.out.print("Coefficient of term " + (i + 1) + ": ");
			coefficients.add(input.nextDouble());
			
			System.out.println("Exponent of term " + (i + 1) + ": ");
			exponents.add(input.nextInt());
		}
		
		Polynomial polynomial = new Polynomial(terms, signs, coefficients, exponents);
		
		testDerivativeFinder(polynomial);
	}
	
	public static void testDerivativeFinder(Polynomial polynomial) {
		
		DerivativeFinder derivativeFinder = new DerivativeFinder();
	
		
		System.out.println("Polynomial:\n" + polynomial);
		
		System.out.println("\nDerivative of polynomial:");
		System.out.println(derivativeFinder.findDerivative(polynomial));
	}
	
}