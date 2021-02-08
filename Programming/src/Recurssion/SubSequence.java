package Recurssion;

import java.util.Scanner;

public class SubSequence {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		subSequence(input,"");
	}

	private static void subSequence(String input, String answer) {
		// TODO Auto-generated method stub
		if(input.length() == 0) {
			System.out.println(answer);
			return;
		}
		
		char toOperate = input.charAt(0);
		String rem = input.substring(1);
		subSequence(rem, answer);
		subSequence(rem, answer+toOperate);
		subSequence(rem, answer+(int)toOperate);
	}

}
