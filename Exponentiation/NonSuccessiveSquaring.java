package com.jerryhuang.exponentiation;

import java.util.Scanner;

public class NonSuccessiveSquaring {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter base number: ");
		int baseNum = input.nextInt();
		System.out.println("Enter the exponent: ");
		int exponent = input.nextInt();
		
		System.out.println(exp(baseNum, exponent));
		
	}
	
	public static long exp(int baseNum, int exponent) {
		
		if (exponent == 0) {
			return 0;
		}
		else if (exponent == 1) {
			return baseNum;
		}
		
		else if (exponent == 2) {
			return (baseNum^2);
		}
		
		else if (exponent % 2 == 0) {
			long sum = 1;
			for (long i = exponent; i >= 1; i/=2) {
				sum *= baseNum ^ 2;
			}
			
			return sum;
		}
		
		else {
			long sum = baseNum;
			for (long i = exponent - 1; i >=1 ; i /=2) {
				sum *= baseNum ^ 2;
			}
			return sum;
		}
		
	}

}
