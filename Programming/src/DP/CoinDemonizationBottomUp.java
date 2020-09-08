package DP;

public class CoinDemonizationBottomUp {
	
	static int dpArr [] = new int [1000];
	
	
	public static void main(String[] args) {

		int coins [] = {2,3,5,6};
		int amount = 10 ;
		//int currentIndex = 0;
		int min  = Integer.MAX_VALUE;
	
		System.out.println(minAmount(amount,coins));
 	
	}


	private static int minAmount(int amount, int[] coins) {
		// TODO Auto-generated method stub
		dpArr[0] = 0;
		
		for (int i = 1 ; i <= amount ; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0 ; j < coins.length ; j++) {
				if(i - coins[j] >= 0) {
					min = Math.min(min, dpArr[i - coins[j]] + 1);
				}
			}
		if(min != Integer.MAX_VALUE)
		dpArr[i] = min;
		}
		
		return dpArr[amount];
	}
	
}
