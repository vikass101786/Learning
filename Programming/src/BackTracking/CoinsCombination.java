package BackTracking;

public class CoinsCombination {

	public static void main(String[] args) {
		int arr[] = {1,2,2,3,4};
		int coins [] = {1,2,3,4,5};
		int totalAmount = 7;
		coinsComina(arr,totalAmount, 0, 0 , "");
		System.out.println("===================");
		//int arr[] = {1,2,2,3,4};
		coinCombinationCase3(arr, totalAmount, 0, "");
		System.out.println("===================");
		coinCombinationCase4(arr, totalAmount, 0, "");
		System.out.println("===================");
		coinCombinationCase5(arr, totalAmount, "");
	}

	private static void coinsComina(int[] coins, int totalAmount,int currentAmount, int index, String answer) {
		// TODO Auto-generated method stub
		if(totalAmount == currentAmount) {
			System.out.println(answer);
			return;
		}
		
		for (int coin = index ; coin < coins.length ; coin++) {
			
			if(coins[coin] + currentAmount <= totalAmount) {
				coinsComina(coins, totalAmount, currentAmount+coins[coin], coin, answer+" "+coins[coin]);
			}
		}
		
		/* 2 2 2 2 2
		 2 2 3 3
		 2 2 6
		 2 3 5
		 5 5*/

		
	}
	
	
	private static void coinCombinationCase3(int[] coins, int totalAmount, int vIdx, String answer) {
		if (totalAmount == 0) {
			System.out.println(answer);
			return;
		}
		
		if(totalAmount < 0 ) {
			return;
		}

		for (int i = vIdx; i < coins.length; i++) {
			if (i > vIdx && coins[i] == coins[i - 1]) {
				continue;
			}
				coinCombinationCase3(coins, totalAmount - coins[i], i + 1, answer + " " + coins[i]);
			
		}
	}
	
	private static void coinCombinationCase4(int[] coins, int totalAmount, int vIdx, String answer) {
		if (totalAmount == 0) {
			System.out.println(answer);
			return;
		}
		
		if(totalAmount < 0 ) {
			return;
		}

		for (int i = vIdx; i < coins.length; i++) {
			if (i > vIdx && coins[i] == coins[i - 1]) {
				continue;
			}
				coinCombinationCase3(coins, totalAmount - coins[i], vIdx + 1, answer + " " + coins[i]);
			
		}
	}
	
	private static void coinCombinationCase5(int[] coins, int totalAmount , String answer) {
		if (totalAmount == 0) {
			System.out.println(answer);
			return;
		}
		
		if(totalAmount < 0 ) {
			return;
		}
		
		for (int i = 0; i < coins.length; i++) {
			coinCombinationCase5(coins, totalAmount - coins[i], answer + " " + coins[i]);
			
		}
	}
	
	
}
