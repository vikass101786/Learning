package Recurssion;

import java.util.Scanner;

public class LCS {

	
	static int dpArr [] = new int [1000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-- > 0) {
			int length = sc.nextInt();
			int arr [] = new int [length];
			for (int i= 0 ; i < arr.length ; i++) {
				arr[i] = sc.nextInt();
			}
			dpArr[0] = 1;
			System.out.println(largestCommonSubsequence(arr,length));
		}
	}

	private static int largestCommonSubsequence(int[] arr , int length) {
		// TODO Auto-generated method stub
		
		for (int i = 1 ; i < length ; i++) {
			for (int j = i-1 ; j >= 0 ; j--) {
				if(arr[i] >= arr[j])
				dpArr[i] = Math.max(dpArr[j], dpArr[i]);
			}
			dpArr[i] += 1;
		}
		
		
		return dpArr[length -1];
	}
}
