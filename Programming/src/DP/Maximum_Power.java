package DP;

import java.util.Scanner;

public class Maximum_Power {

	/*
	 * Alice is fighting with an alien to save this planet. As alien is very
	 * powerful he needs some power to overcome him. Power points are represented in
	 * the form of an array containing both positive and negative powers but the
	 * problem is he can get power equal to the product of the subarray he selects.
	 * Help him to decide maximum power he can get.
	 * 
	 * Input Format First line contains an integral value denoting the size of array
	 * 'n' and then next line represents the array elements.
	 * 
	 * Constraints 1<=n<=100000 Product of all numbers will fit in long long int.
	 * 
	 * Output Format Single integer denoting the maximum power.
	 * 
	 * Sample Input 
	 * 
	 * 8 10 1 2 -13 0 7 -18 2 
	 * 
	 * Sample Output 
	 * 
	 * 20
	 * 
	 */

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		long arr[] = new long[length];
		for (int i = 0; i < length; i++)
			arr[i] = sc.nextLong();
		long dpArr[][] = new long[length][2];
		System.out.println(maxPower(arr, dpArr));
	}

	public static long maxPower(long[] arr, long[][] dp) {
		long max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0) {
				dp[i][0] = Math.max(arr[i], arr[i] * (i - 1 >= 0 ? dp[i - 1][0] : 0));
				dp[i][1] = arr[i] * (i - 1 >= 0 ? dp[i - 1][1] : 0);
			} else {
				dp[i][0] = arr[i] * (i - 1 >= 0 ? dp[i - 1][1] : 0);
				dp[i][1] = Math.min(arr[i], arr[i] * (i - 1 >= 0 ? dp[i - 1][0] : 0));
			}
			max = dp[i][0] >= max ? dp[i][0] : max;
		}
		return max;
	}
}
