package Recurssion;

import java.util.Scanner;

public class RemoveDup {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(str.substring(0,1)+seperateStr(str,1));
	}

	private static String seperateStr(String str, int i) {
		
		if(i == str.length()) {
			return str.substring(i);
		}
		
		
		if(str.substring(i-1, i).equals(str.substring(i, i+1))) {
			return ("*"+str.substring(i, i+1)) + seperateStr(str, i+1);
		}
		
		return str.substring(i, i+1) + seperateStr(str, i+1);
	}
	
}
