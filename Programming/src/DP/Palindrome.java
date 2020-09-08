package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {
	
	public static int dp [][] = new int [15][15];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-- > 0) {
			String str = sc.next();
			//int ln = sc.nextInt();
			//int rn = sc.nextInt();
			for(int i = 0 ; i < dp.length ; i++) {
				Arrays.fill(dp[i], -1);
			}
			boolean ans = isPalindrome(str,0,str.length()-1) == 1 ? true :false;
			System.out.println(ans);
			//System.out.println(dp[ln][rn]);
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int isPalindrome(String str, int l, int r) {
		// TODO Auto-generated method stub
		
		if(r < l) {
			return 1;
		}
		
		if(r - l == 0) {
			return 1;
		}
		
		if(dp[l][r] != -1) {
			return dp[l][r];
		}
		
		int ans = 0;
		if(isPalindrome(str, l+1, r-1) == 1 && str.charAt(l) == str.charAt(r)) {
			ans = 1;
		}
		
		dp[l][r] = ans;
		
		return ans;
	}
	
}
