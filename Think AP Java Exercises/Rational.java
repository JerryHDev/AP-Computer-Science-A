/** Jerry Huang
 * APCS, Period 2
 * Kuszmaul
 * Think AP Java Exercise Ch15.4
 */


public class Rational {
	
	public int numerator;
	public int denominator;
	
	// Testing methods
	public static void main(String[] args) {
		Rational rationalNum = new Rational(6, 2); // Values can be changed for testing
		Rational rationalNum2 = new Rational(5, 3); // Values can be changed for testing
		printRational(rationalNum);
		printRational(rationalNum2);
		Rational sum = rationalNum.add(rationalNum2);
		System.out.println("The sum is " + sum.numerator + "/" + sum.denominator);
		printRational(rationalNum);
		rationalNum.negate();
		printRational(rationalNum);
		System.out.println("The double value of the rational number is " + rationalNum.toDouble());
		rationalNum.reduce();
		
	}
	
	public Rational() {
		numerator = 0;
		denominator = 1;
	}
	
	/** Arg constructor
	 * @param numerator
	 * @param denominator
	 */
	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	// Reverses the sign of the rational number
	public void negate() {
		numerator = numerator * (-1);
	}
	
	// Inverts the numerator and denominator of the rational number
	public void invert() {
		int tempNum = numerator;
		numerator = denominator;
		denominator = tempNum;
	}
	
	// Converts rational number to double value
	public double toDouble() {
		return (numerator / denominator);
	}
	
	// Reduces a rational number by finding gcd
	public void reduce() {
		int gcd = gcd(numerator, denominator);
		System.out.println("The reduced rational number is " + numerator / gcd + "/" + denominator / gcd);
	}
	public static int gcd(int first, int second) {
		while (second != 0) {
			int tempNum = first;
			first = second;
			second = tempNum % second;
		}
		return first;
	}
	
	// Adds two rational numbers
	public Rational add(Rational num2) {
		int gcd = 0;
		int tempDenominator = denominator;
		denominator = denominator * num2.denominator;
		numerator = numerator * num2.denominator;
		num2.denominator = num2.denominator * tempDenominator;
		num2.numerator = num2.numerator * tempDenominator;
		int numeratorSum = numerator + num2.numerator;
		if (numeratorSum > denominator) {
			gcd = gcd(numeratorSum, denominator);
		}
		else {
			gcd = gcd(denominator, numeratorSum);
		}
		Rational newNum = new Rational (numeratorSum / gcd, denominator / gcd);
		return newNum;
		
	}
	
	// Prints rational number
	public static void printRational(Rational num) {
		System.out.println("The rational number is: " + num.numerator + "/" + num.denominator);
	}
}