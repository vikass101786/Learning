package DP;

import java.util.Arrays;

public class wineProblem {
	
	static int dpArr [][]; 
	
	public static void main(String[] args) {
		int arr [] = {1,4,2,3};
		int left = 0;
		int right = arr.length -1;
		int sum = 0;
		int year = 1;
		dpArr = new int [arr.length][arr.length];
		for (int i = 0 ; i < dpArr.length ; i++) {
			Arrays.fill(dpArr[i], -1);
		}
		//maxProit(arr , left , right, sum , year);
		//System.out.println(maxProit1(arr, left, right, year));
		//System.out.println(maxProfitMemoizedSol(arr, left, right, year));
		System.out.println(maxProfitBottomUp(arr, left, right, year));
	}

	private static void maxProit(int[] arr, int left, int right, int sum , int year) {
		// TODO Auto-generated method stub
		if(left > right) {
			System.out.println(sum);
			return;
		}
		
		maxProit(arr, left+1, right, sum + (arr[left] * year), year+1);
		maxProit(arr, left, right-1, sum + (arr[right] * year), year+1);
	}
	
	private static int maxProit1(int[] arr, int left, int right, int year) {
		// TODO Auto-generated method stub
		if(year > arr.length) {
			return 0;
		}
		int q1 = Integer.MIN_VALUE , q2 = Integer.MIN_VALUE;
		q1 = arr[left]*year + maxProit1(arr, left+1, right, year+1);
		q2 = arr[right]*year + maxProit1(arr, left, right-1, year+1);
		
		return Math.max(q1, q2);
	}
	
	private static int maxProfitMemoizedSol(int[] arr, int left, int right, int year) {
		if(year > arr.length) {
			return 0;
		}
		
		if(dpArr[left][right] != -1) return dpArr[left][right];
		
		int q1 = Integer.MIN_VALUE , q2 = Integer.MIN_VALUE;
		
		q2 = arr[right]*year + maxProfitMemoizedSol(arr, left, right-1, year+1);
		q1 = arr[left]*year + maxProfitMemoizedSol(arr, left+1, right, year+1);
		
		dpArr[left][right] = Math.max(q1, q2);
		return dpArr[left][right];
	}
	
	private static int maxProfitBottomUp(int[] arr , int left, int right, int year) {
		
		int n = arr.length;
		year = arr.length;
		for (int i = 0 ; i < arr.length ; i++) {
			dpArr[i][i] = arr[i]*year;
		}
		
		for (int len = 2 ; len <= n ; len++) {
			year--;
			int srt = 0;
			int end = n - len;
			while(srt <= end) {
				int endWindow = srt + len - 1;
				dpArr[srt][endWindow] = Math.max(arr[srt]*year + dpArr[srt+1][endWindow] , arr[endWindow]*year + dpArr[srt][endWindow-1]);
				srt++;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(" " + dpArr[i][j] +" ");
			}
			System.out.println();
		}
		
		return dpArr[0][n-1];
	}
	
}
