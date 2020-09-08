package Maths;

import java.util.Scanner;

public class Substring {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-- > 0) {
			String str = sc.next();
			printAllSubString(str ,0, "");
		}
	}

	private static void printAllSubString(String str , int i , String ans) {
		// TODO Auto-generated method stub
		if(str.length() == i) {
			System.out.println(ans +" ==== " );
			if(ans.length() > 0 && ans.charAt(0) == '1' && ans.charAt(ans.length()-1) == '1') {
			System.out.println(ans);
			}
			return;
		}
		
		if(ans.length() == i || ans.length() < 1) {
		printAllSubString(str, i+1, ans + str.charAt(i));
		}
		printAllSubString(str, i+1, ans);
	}
}
