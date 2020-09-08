package Recurssion;

import java.util.Scanner;

public class MoveAllXAtEnd {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(moveXAtEnd(str,0));
	}

	private static String moveXAtEnd(String str, int i) {
		// TODO Auto-generated method stub
		if(str.length()-1 <= i) {
			return str;
		}
		
		String output = moveXAtEnd(str, i+1);
		
		if(str.substring(i, i+1).equals("x")) {
			output = output.substring(0,i) + output.substring(i+1) + str.substring(i, i+1);
		} else {
			return output;
		}
		
		return output;
	}
	
	/*
	 * public static String move(String s) { if (s.length() <= 1) return s;
	 * 
	 * String ros = s.substring(1); ros = move(ros); if (s.charAt(0) == 'x') return
	 * ros + s.charAt(0); else return s.charAt(0) + ros; }
	 * 
	 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
	 * String s = sc.next();
	 * 
	 * System.out.println(move(s)); }
	 */
	
}
