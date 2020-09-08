package DP;

import java.util.Scanner;

public class StairsClimbing_BU {
	
	// complexity of this problem O(n*k)
	
	static int dpArr [] = new int [1000];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int totalSteps = sc.nextInt();
		int maxSteps = sc.nextInt();
		dpArr[0] = dpArr[1] = 1; 
		System.out.println(totalWays(totalSteps,maxSteps));
		
	
	}

	private static int totalWays(int totalSteps, int maxSteps) {
		// TODO Auto-generated method stub
		
		int sum = dpArr[1];
		
		for (int i = 2 ; i <= maxSteps ; i++ ) {
			dpArr[i] = sum + 1;
			sum += dpArr[i];
		}
		
		
		for (int i = maxSteps+1 ; i <= totalSteps ; i++) {
			int k = maxSteps;
			int currentSum = 0;
			while(k > 0) {
				currentSum += dpArr[i-k];
				k--;
			}
			dpArr[i] = currentSum;
		}
		
		return dpArr[totalSteps];
	}
	
}
