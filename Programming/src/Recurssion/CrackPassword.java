package Recurssion;

import java.util.Scanner;

public class CrackPassword {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
				
		while(testCases-- > 0) {
			int length = sc.nextInt();
			int start = 0;
			printPassword(length,"");
		}
	}

	private static void printPassword(int length, String string) {
		// TODO Auto-generated method stub
		
		if(length == 0) {
			System.out.println(string);
			return;
		}
		
		for (int i = 1 ; i <= 9 ; i++) {
			printPassword(length -1 , string + i);
		}
		
	}

}
