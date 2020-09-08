package DP;

public class CoinDemonizationDPTopDown {

	
	static int dpArr [] = new int [1000];
	
	public static void main(String[] args) {
		int coins [] = {2,3,5,6};
		int amount = 10;
		System.out.println(minAmount(amount,coins));
 	}

	private static int minAmount(int amount, int[] coins) {
		if(amount == 0) {
			return 0;
		}

		
		  if(dpArr[amount] != 0) { return dpArr[amount]; }
		 
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0 ; i < coins.length ; i++) {
			if((amount - coins[i]) >= 0) {
				int q1 =   minAmount(amount - coins[i], coins);
                if(q1 != Integer.MAX_VALUE) {
				min = Math.min(min, q1+1);
                }
			}	
		}	
		dpArr[amount] = min;
		return  dpArr[amount] ;
	}
	
}
