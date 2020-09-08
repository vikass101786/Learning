package DP;

import java.util.Scanner;

public class StairsClimbing {
	
	static int dpArr [] = new int [1000]; 
			
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalSteps = sc.nextInt();
		int maxSteps = sc.nextInt();
		System.out.println(totalWays(totalSteps,maxSteps));
	}

	private static int totalWays(int totalSteps, int maxSteps) {
		// TODO Auto-generated method stub
		
		if(totalSteps == 0) {
			return 1;
		}
		
		if(totalSteps < 0) {
			return 0;
		}
		
		int count = 0;
		
		if(dpArr[totalSteps] != 0) {
			return dpArr[totalSteps];
		} 
		
		for (int i =1 ; i <= maxSteps ; i++) {
			count += totalWays(totalSteps - i , maxSteps);
			dpArr[totalSteps] = count;
		}
		
		return dpArr[totalSteps];
	}
}
