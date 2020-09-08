package DP;

public class CoinsDemonizationNoOfWays {

	public static void main(String[] args) {
		int coins[] = { 2, 3, 5, 6 };
		int amount = 10;
		System.out.println(findNumberOfWays(coins, amount, coins.length - 1));
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

		int q1 = findNumberOfWays(coins, amount - coins[i], i);
		int q2 = findNumberOfWays(coins, amount, i - 1);

		return q1+q2;
	}
}
