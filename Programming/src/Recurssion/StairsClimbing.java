package Recurssion;

import java.util.Scanner;

public class StairsClimbing {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stairCount = sc.nextInt();
		int maxStep = sc.nextInt();
		int count = 0;
		System.out.println(stepCount(stairCount, maxStep/* , count */ ));
	}

	private static int stepCount(int stairCount, int maxStep) {
		// TODO Auto-generated method stub
		
		if(stairCount == 0) {
			//System.out.println("  stepCount( "+stairCount +" , " + maxStep +" , " + count +") === > return 1");
			System.out.println("  stepCount( "+stairCount +" , " + maxStep +" , ) === > return 1");
			System.out.println("========== FINISHED 1 WAY ======================");
			return 1;
		}
		
		if(stairCount < 0) {
			//System.out.println("  stepCount( "+stairCount +" , " + maxStep +" , " + count +") === > return 0");
			System.out.println("  stepCount( "+stairCount +" , " + maxStep +" ,) === > return 0");
			return 0;
		}
		int count = 0;
		for(int i = maxStep ; i > 0 ; i--) {
			System.out.println(i + " stepCount( "+stairCount +" , " + maxStep +" , " + count +")");
			 int currentCount = stepCount(stairCount-i, maxStep /*,count*/);
			 //System.out.println(i + " stepCount( "+stairCount +" , " + maxStep +" , " + count +") == pop currentCount " + currentCount);
			System.out.println(i + " stepCount( "+stairCount +" , " + maxStep +" , " + count +") == pop currentCount " + currentCount);
			count = currentCount + count;
		}
		
		return count;
	}
	
}
