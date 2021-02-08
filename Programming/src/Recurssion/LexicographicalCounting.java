package Recurssion;

import java.util.Scanner;

public class LexicographicalCounting {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start_num = sc.nextInt();
		int end_num = sc.nextInt();
		printLexicographically(start_num, end_num);
	}

	private static void printLexicographically(int start_num, int end_num) {
		// TODO Auto-generated method stub
		if (start_num > end_num) {
			return;
		}
		
		System.out.println(start_num);
		
		int i = 0;
		
		if (start_num == 0) {
			i = 1;
		}
		
		while(i <= 9) {
			printLexicographically(start_num*10+i, end_num);
			i++;
		}
		
		
	}

}
