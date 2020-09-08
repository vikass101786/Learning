package DP;

import java.util.Arrays;
import java.util.Scanner;

public class CalvinsGameDP {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr [] = new int [n];
		long dpF [] = new long [n];
		long dpB [] = new long [n];
		for (int i = 0 ; i < arr.length ;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.fill(dpB, Integer.MIN_VALUE);
		Arrays.fill(dpF, Integer.MIN_VALUE);
		
		fillForwardDP(k,n,dpF,arr);
		fillBackwardDP(0,n,dpB,arr);
		
		System.out.println(maxScore(dpB,dpF,arr,k,n));
	}

	private static long maxScore(long[] dpB, long[] dpF, int[] arr,int k,int length) {
		// TODO Auto-generated method stub
		long ans = Integer.MIN_VALUE;
		for (int i = k ; i < length ; i++) {
			long maxValueForIndex = dpB[i] + dpF[i] - arr[i];
			ans = Math.max(maxValueForIndex, ans);
		}
		return ans;
	}

	private static void fillBackwardDP(int start, int n, long[] dpB, int[] arr) {
		for (int i = start ; i < n ; i++) {
			dpB[i] = arr[i] + Math.max(i-1 < 0 ? 0:dpB[i-1], i-2 < 0 ? 0:dpB[i-2]);
		}
		
	}

	private static void fillForwardDP(int k, int n, long[] dpF,int [] arr) {
		for (int i = k ; i < n ; i++) {
			dpF[i] = arr[i] + Math.max(i-1 <= k ? 0 : dpF[i-1], i-2 <= k ? 0 : dpF[i-2]);
		}
	}
}
