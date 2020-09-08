package Recurssion;

import java.util.Scanner;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(removeDup(str,0));
	}

	private static String removeDup(String str , int i) {
		// TODO Auto-generated method stub
		if(i == str.length()) {
			return str.substring(i);
		}
		
		if( i < str.length()-1 && str.substring(i, i+1).equals(str.substring(i+1, i+2))) {
			return removeDup(str, i+1);
		}
		
		return str.substring(i, i+1) + removeDup(str, i+1);
	}

}
