import java.util.ArrayList;



/*
 * Coded by Jerry Huang
 * 5/25/16
 * 
 * DerivativeFinder Class
 * 
 * Every object represents a derivative finder which can be used to find the
 * derivative of a polynomial of any degrees and terms.
 */
public class DerivativeFinder {
	
	private Polynomial polynomial;
	private int terms;
	private ArrayList<String> signs = new ArrayList<String>();
	private ArrayList<Double> coefficients = new ArrayList<Double>();
	private ArrayList<Integer> exponents = new ArrayList<Integer>();
	
	
	/**
	 * No-arg C-onstructor creates a DerivativeFinder object used to calculate the derivative of any polynoml.[
	 */
	public DerivativeFinder() {
		
	}
	
	
	/**
	 * Find the derivative of the polynomial
	 * @return derivative polynomial function
	 */
	public Polynomial findDerivative(Polynomial polynomial) {
		
		this.polynomial = polynomial;
		this.terms = polynomial.getNumOfTerms();
		this.signs = polynomial.getSigns();
		this.coefficients = polynomial.getCoefficients();
		this.exponents = polynomial.getExponents();
		
		int newTerms = 0;
		ArrayList<Double> newCoefficients = new ArrayList<Double>();
		ArrayList<Integer> newExponents = new ArrayList<Integer>();
		ArrayList<String> newSigns = new ArrayList<String>();
		
		
		for (int i = 0; i < terms; i++) {
			
			if (exponents.get(i) != 0) {
				newCoefficients.add(exponents.get(i) * coefficients.get(i));
				newExponents.add(exponents.get(i) - 1);
				newTerms++;
			}
		}
		
		return new Polynomial(newTerms, signs, newCoefficients, newExponents);
	}
	
}
