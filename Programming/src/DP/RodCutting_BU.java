package DP;

public class RodCutting_BU {
	
	public static void main(String[] args) {
		int len = 4;
		int profit [] = {0,2,3,2,5};
		System.out.println(rodCuttingProfit(len,profit));
	
	}

	private static int rodCuttingProfit(int totalLen, int[] profit) {
		// TODO Auto-generated method stub
		int dpArr [] = new int [100];
		
		for (int len = 1 ; len <= totalLen ; len++) {
			int best = 0;
			for (int cut = 1 ; cut <= len ; cut++) {
				best = Math.max(best, profit[cut] + dpArr[len-cut]);
			}
			dpArr[len] = best;
		}
		
		return dpArr[totalLen];
	}
	
}
