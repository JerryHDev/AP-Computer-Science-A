
public class Polynomial {
	
	private int degree;
	private double[] coefficients;
	private int[] exponents;
	
	public Polynomial(int degree, double[] coefficients, int[] exponents) {
		this.degree = degree;
		this.coefficients = coefficients;
		this.exponents = exponents;
	}
	
	
	/**
	 *  Setter methods
	 * @param term; the term in the polynomial to modify
	 * @param newCoefficient; the new coefficient to replace with
	 */
	public void replaceCoefficient(int term, double newCoefficient) {
		coefficients[term - 1] = newCoefficient;
	}
	public void replaceExponent(int term, int newExponent) {
		exponents[term - 1] = newExponent;
	}
	
	
	/** Get degree of polynomial */
	public int getDegree() {
		return degree;
	}
	
	/** Get the coefficients of terms */
	public double[] getCoefficients() {
		return coefficients;
	}
	
	/** Get the exponents of terms */
	public int[] getExponents() {
		return exponents;
	}
	
	/**
	 * Find the derivative of the polynomial
	 * @return derivative function
	 */
	public Polynomial getDerivative() {
		
		int newDegree = degree - 1;
		double[] newCoefficients = new double[coefficients.length - 1];
		int[] newExponents = new int[exponents.length - 1];
		
		for (int i = 0; i < newCoefficients.length; i++) {
			newCoefficients[i] = exponents[i] * coefficients[i];
			newExponents[i] = exponents[i] - 1;
		}
		
		return new Polynomial(newDegree, newCoefficients, newExponents);
	}
	
	
	/**
	 * Prints the degree and coefficients of the polynomial
	 */
	public String toString() {
		String name = "Function:\n";
		String retval = "";
		
		for (int i = 0; i < coefficients.length - 1; i++)
			retval += coefficients[i] + "x" + superscript(Integer.toString(exponents[i])) + " + ";
		retval += coefficients[coefficients.length - 1] + "x" + superscript(Integer.toString(exponents[coefficients.length - 1]));
		return name + retval;
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