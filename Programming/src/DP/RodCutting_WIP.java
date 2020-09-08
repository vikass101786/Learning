package DP;

public class RodCutting_WIP {
	
	public static void main(String[] args) {
		int len = 4;
		int profit [] = {2,3,2,5};
		int max = 0;
		System.out.println(rodCuttingProfit(len,profit));
	}

	private static int rodCuttingProfit(int len, int[] profit) {
		// TODO Auto-generated method stub
		if(len <= 0) {
			return 0;
		}
		
		
		int best = 0;
		
		for (int i = 1 ; i < profit.length ; i++) {
			if(i <= len) {
				System.out.println(profit[i-1] + " rodCuttingProfit( " + (len-i) + " ,   {2,3,2,5} )" +" " +i);
				int max = profit[i-1] + rodCuttingProfit(len - i, profit);
			//	System.out.println( "==>" + profit[i-1] + " rodCuttingProfit( " + (len-i) + " ,   {2,3,2,5} )" +" " +i);
				System.out.println("Best : " + best +" :: max :: "+ max);
				best = Math.max(max, best);
				//System.out.println("==>" + "Best : " + best +" :: max :: "+ max);
			}
		}
		//System.out.println(best);
		return best;
	}
	
	
}
