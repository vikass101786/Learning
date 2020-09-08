package Recurssion;

import java.util.Scanner;

public class SolutionOfEquation {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int sum = sc.nextInt();
		printAllEquationCombi(sum,length,sum,"",0,1);
	}

	private static void printAllEquationCombi(int sum, int length, int rem, String string, int le , int k) {
		// TODO Auto-generated method stub
		if(rem == 0 && le == length) {
			System.out.println(string);
			return;
		}
		
		if(k > sum) {
			printAllEquationCombi(sum, length, rem, string, le, 0);
		}
		
		for (int i = k ; i <= sum ; i++) {
			if(rem >= i) {
				printAllEquationCombi(sum, length, rem - i, string + i + " ", i , k+1);
			}
		}
	}
	
}
