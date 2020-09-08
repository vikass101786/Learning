package Recurssion;

import java.util.Scanner;

public class ReplacePi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(replace(str, 0));
	}

	private static String replace(String str, int i) {
		if (str.length() - 1 <= i) {
			return str;
		}

		String res = replace(str, i + 1);
		if (str.substring(i, i + 2).equals("pi")) {
			res = res.substring(0, i) + "3.14" + res.substring(i + 2);
		} else {
			return res;
		}
		return res;
	}

	/*
	 * private static String replace(String str, int i) { if(str.length()-1 <= i) {
	 * return str; }
	 * 
	 * String res = replace(str, i+1); if(str.substring(i,i+2).equals("pi")) { res =
	 * res.substring(0, i) + "3.14"+res.substring(i+2); } else { return res; }
	 * return res; }
	 */

}
