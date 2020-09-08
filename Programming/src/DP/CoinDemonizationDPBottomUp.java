package DP;

import java.util.Arrays;
import java.util.Scanner;

public class CoinDemonizationDPBottomUp {
	
	static int dp [] = new int [1000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		int length = sc.nextInt();
		int coins [] = new int [length];
		for(int i = 0 ; i < length ; i++) {
			coins[i] = sc.nextInt();
		}
		System.out.println(minNumberOfCoins(amount,coins));
	}

	private static int minNumberOfCoins(int amount, int[] coins) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < coins.length ; i++) {
			dp[coins[i]] = 1;
		}
		
		for(int i = 0 ; i <= amount ; i++) {
			if(dp[i] == 0) {
				if(i < coins[0]) {
					dp[i] = Integer.MAX_VALUE;
				} else {
				int min = Integer.MAX_VALUE;
				for (int k = 0 ; k < coins.length ; k++) {
					if( (i - coins[k]) >= 0  && dp[i - coins[k]] != Integer.MAX_VALUE) {
						min = Math.min(min, dp[i - coins[k]]);
					}
				}
				dp[i] = min+1;
				}
			}
		}
		return dp[amount];
	}
	
}
