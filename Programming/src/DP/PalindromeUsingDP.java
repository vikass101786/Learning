package DP;

import java.util.Scanner;

public class PalindromeUsingDP {
	
   static int dp [][];
   static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int len = input.length();
		dp = new int [len][len];
		findPalindromicStringCount(input);
		System.out.println(count);
	}

	private static void findPalindromicStringCount(String input) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < input.length() ; i++) {
			count++;
			dp[i][i] = count;
			System.out.println(input.charAt(i));
		}
		
		for (int i = 1 ; i < input.length() ; i++) {
			if(input.charAt(i) == input.charAt(i-1)) {
				count++;
				dp[i-1][i] = count;
				System.out.println(input.substring(i-1,i+1));
			}
		}
		
		int k = 0;
		for (int i = 2 ; i < input.length() ; i++) {
			k = 0;
			 for (int j = i ; j < input.length() ; j++) {
				 if (dp [k+1][j-1] != 0 && input.charAt(j) == input.charAt(k)) {
					 count++;
					 dp[k][j] = count;
					 System.out.println(input.substring(k,j+1));
				 }
				 k++;
			 }
		}
	}

}
