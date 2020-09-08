package DP;

public class RodCutting_Memoized {
	
	static int dpArr [] = new int [1000];
	
	public static void main(String[] args) {

		int len = 4;
		int profit [] = {2,3,2,5};
		
		System.out.println(rodCuttingProfit(len,profit));
	
	}

	private static int rodCuttingProfit(int len, int[] profit) {
		// TODO Auto-generated method stub
		
		if(len <= 0) return 0;
		
		if(dpArr[len] != 0) {
			return dpArr[len];
		}
		int best = 0;
		for (int i = 1 ; i < profit.length ; i++) {
			if(i <= len) {
				int max = profit[i -1] + rodCuttingProfit(len -i, profit);
				best = Math.max(max, best);
				dpArr[len] = best;
			}
		}
		return dpArr[len];
	}
}
