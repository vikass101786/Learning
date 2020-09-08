package Recurssion;

import java.util.Scanner;

public class PermutationUsingString {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		permutation(str,0);
	}

	private static void permutation(String str, int i) {
		// TODO Auto-generated method stub
		if(i == str.length()) {
			System.out.println(str);
			return;
		}
		
		for (int k = i ; k < str.length() ; k++) {
			String newStr = swap(str.toCharArray(),i,k);
			permutation(newStr, i+1);
		}
		
	}

	private static String swap(char [] strArray, int i, int k) {
		// TODO Auto-generated method stub
		char temp = strArray[i];
		strArray[i] = strArray[k];
		strArray[k] = temp;
		String str = new String(strArray);
		return str;
	}
	
}
