package DP;

public class CoinDemonization {

	public static int count = 0;

	public static void main(String[] args) {
		System.out.println(3/4);
		int coins[] = { 2, 3, 5, 6 };
		int amount = 10;
		System.out.println(minAmount(amount, coins ,""));
		System.out.println(count);
	}

	private static int minAmount(int amount, int[] coins , String coStr) {
		// TODO Auto-generated method stub
		if (amount < 0) {
			return 0;
		}

		if (amount == 0) {
			System.out.println(coStr);
			count++;
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < coins.length; i++) {
			if ((amount - coins[i]) >= 0) {
				int q1 = minAmount(amount - coins[i], coins,coStr+coins[i]+" ");
				if (q1 != Integer.MAX_VALUE) {
					min = Math.min(min, q1 + 1);
				}
			}
		}
		return min;
	}

}
