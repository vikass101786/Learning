package DP;

import java.util.Scanner;

public class StairsClimbing_BU_WindowSliding {
	
	static int dpArr [] = new int [1000];
	
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int totalSteps = sc.nextInt();
		int maxSteps = sc.nextInt();
		dpArr[0] = dpArr[1] = 1; 
		System.out.println(totalWays(totalSteps,maxSteps));
	}

	// complexity O(n+k)
	// recurrence relation dp [i] = 2*dp[i-1] - dp[i - (k+1)]
	
	private static int totalWays(int totalSteps, int maxSteps) {
		// TODO Auto-generated method stub
		
		for (int i = 2 ; i <= totalSteps ; i++) {
			if((i-(maxSteps+1)) >= 0) {
				dpArr[i] = 2*dpArr[i-1] - dpArr[i-(maxSteps+1)];
			} else {
				dpArr[i] = 2*dpArr[i-1];
			}
		}
		
		return dpArr[totalSteps];
	}
}
