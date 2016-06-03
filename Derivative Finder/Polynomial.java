import java.util.ArrayList;



/*
 * Coded by Jerry Huang
 * 5/6/16
 * 
 * Polynomial Class
 * 
 * Every object represents a polynomial with x terms.
 * Every Polynomial object has:
 * Terms - the number of terms in the polynomial
 * Signs - the sign value of every term
 * Coefficients
 * Exponents - the exponential value of x of each term
 * 
 * Setter methods can change the signs, coefficients, and exponents of a Polynomial object.
 * 
 */
public class Polynomial {
	
	private int terms;
	private ArrayList<String> signs = new ArrayList<String>();
	private ArrayList<Double> coefficients = new ArrayList<Double>();
	private ArrayList<Integer> exponents = new ArrayList<Integer>();
	
	
	public Polynomial(int terms, ArrayList<String> signs, ArrayList<Double> coefficients, ArrayList<Integer> exponents) {
		this.terms = terms;
		this.signs = signs;
		this.coefficients = coefficients;
		this.exponents = exponents;
	}
	
	
	/**
	 *  Replaces coefficient with new coefficient
	 * @param term; the term in the polynomial to modify
	 * @param newCoefficient; the new coefficient to replace with
	 */
	public void replaceCoefficient(int term, double newCoefficient) {
		coefficients.set(term - 1, newCoefficient);
	}
	
	public void replaceSign(int term, String sign) {
		signs.set(term - 1, sign);
	}
	public void replaceExponent(int term, int newExponent) {
		exponents.set(term - 1, newExponent);
	}
	
	
	/** Get degree of polynomial */
	public int getNumOfTerms() {
		return terms;
	}
	
	/** Get the signs in the polynomial */
	public ArrayList<String> getSigns() {
		return signs;
	}
	
	/** Get the coefficients of terms */
	public ArrayList<Double> getCoefficients() {
		return coefficients;
	}
	
	/** Get the exponents of terms */
	public ArrayList<Integer> getExponents() {
		return exponents;
	}
	
	
	/**
	 * Prints the degree and coefficients of the polynomial
	 */
	public String toString() {
		String retval = "";
		
		for (int i = 0; i < terms; i++)
			retval += " " + signs.get(i) + coefficients.get(i) + "x" + superscript(Integer.toString(exponents.get(i)));
		return retval;
	}
	
	
	/** Converts string to substring */
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