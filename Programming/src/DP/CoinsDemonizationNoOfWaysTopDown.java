package DP;

import java.util.Arrays;

public class CoinsDemonizationNoOfWaysTopDown {


	public static int dp[][] = new int[4][11];

	public static void main(String[] args) {
		int coins[] = { 2, 3, 5, 6 };
		int amount = 10;
		for (int i = 0; i < coins.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(findNumberOfWays(coins, amount, coins.length - 1));

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int findNumberOfWays(int[] coins, int amount, int i) {
		// TODO Auto-generated method stub

		if (amount < 0) {
			return 0;
		}

		if (amount == 0) {
			return 1;
		}

		if (i < 0) {
			return 0;
		}

		if (dp[i][amount] != -1) {
			return dp[i][amount];
		}

		int q1 = findNumberOfWays(coins, amount - coins[i], i);
		int q2 = findNumberOfWays(coins, amount, i - 1);

		if (i >= 0 && amount >= 0) {
			dp[i][amount] = q1 + q2;
		}

		return dp[i][amount];
	}

}
