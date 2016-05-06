import java.util.Scanner;

public class Main {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		createFunction();
		
		
	}
	
	public static void testPolynomialClass(Polynomial function) {
		
		System.out.println("\n" + function);
		
		System.out.println("\nAfter finding derivative... New function is...\n");
		System.out.println(function.getDerivative());
	}
	
	
	public static void createFunction() {
		System.out.print("Degree of polynomial: ");
		int degree = input.nextInt();
		
		double[] coefficients = new double[degree + 1];
		int[] exponents = new int[degree + 1];
		
		for (int i = 0; i < coefficients.length; i++) {
			System.out.print("Coefficient of x" + superscript(Integer.toString(degree - i)) + " ");
			coefficients[i] = input.nextDouble();
			exponents[i] = degree - i;
		}
		
		Polynomial function = new Polynomial(degree, coefficients, exponents);
		
		testPolynomialClass(function);
	}
	
	
	public static String superscript(String str) {
	    str = str.replaceAll("0", "⁰");
	    str = str.replaceAll("1", "¹");
	    str = str.replaceAll("2", "²");
	    str = str.replaceAll("3", "³");
	    str = str.replaceAll("4", "⁴");
	    str = str.replaceAll("5", "⁵");
	    str = str.replaceAll("6", "⁶");
	    str = str.replaceAll("7", "⁷");
	    str = str.replaceAll("8", "⁸");
	    str = str.replaceAll("9", "⁹");         
	    return str;
	}
}