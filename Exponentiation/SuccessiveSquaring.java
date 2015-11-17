// Jerry Huang
// APCS
// Period 2
// This program implements exponentiation using successive squaring

package com.jerryhuang.exponentiation;

import java.util.Scanner;

public class SuccessiveSquaring {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a base number: ");
		double baseNum = input.nextDouble();
		System.out.println("Enter the exponent: ");
		double exponent = input.nextDouble();
		
		System.out.print(expBySquaring(baseNum, exponent));
		
	}
	
	public static double expBySquaring(double baseNum, double exponent) {
		
		if (exponent == 0) {
			return 1;
		}
		
		else if (exponent == 1) {
			return baseNum;
		}
		
		else if (exponent == 2) {
			return baseNum * baseNum;
		}
		
		else if (exponent % 2 == 0) { // if exponent is even
			
			return expBySquaring(baseNum * baseNum, exponent / 2); // repeats until exponent becomes 1	
		}
		
		else  { // if exponent is odd
			
			return baseNum * expBySquaring(baseNum * baseNum, (exponent - 1) / 2);
		}	
	}
}