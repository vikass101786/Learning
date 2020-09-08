package DP;

public class RodCUtting {
	public static void main(String[] args) {
		int len = 4;
		int profit [] = {2,10,11,9};
		int max = 0;
		System.out.println(rodCuttingProfit(len,profit));
	}

	private static int rodCuttingProfit(int len, int[] profit) {
		// TODO Auto-generated method stub
		
		if(len <= 0) {
			return 0;
		}
		
		int q1 = Integer.MIN_VALUE ; 
		int q2 = Integer.MIN_VALUE ; 
		int q3 = Integer.MIN_VALUE ; 
		int q4 = Integer.MIN_VALUE ;
		
		if(len >= 4) q1 = profit[3] + rodCuttingProfit(len - 4, profit);
		if(len >= 3) q2 = profit[2] + rodCuttingProfit(len - 3, profit);
		if(len >= 2) q3 = profit[1] + rodCuttingProfit(len - 2, profit);
		if(len >= 1) q4 = profit[0] + rodCuttingProfit(len - 1, profit);
		
		return Math.max(Math.max(q1, q2), Math.max(q3, q4));
	}
}
