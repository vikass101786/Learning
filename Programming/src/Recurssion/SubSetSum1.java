package Recurssion;

import java.util.Scanner;

public class SubSetSum1 {

	public static boolean isAvailable;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases-- > 0) {
			int length = sc.nextInt();
			int arr[] = new int[length];

			for (int i = 0; i < length; i++) {
				arr[i] = sc.nextInt();
			}

			subSetSum(arr, 0, 0,false);
		}
	}

	public static void subSetSum(int[] arr, int index, int sum , boolean isAvailable) {

		if (index == arr.length) {
			if (sum == 30 && isAvailable) {
				System.out.println("Yes");
				return;
			}
			return;
		}

		subSetSum(arr, index + 1, sum + arr[index] , true);
		subSetSum(arr, index + 1, sum , isAvailable);
	}

	
	
	public static boolean subsetSumEasy(int[] v, int i, int sum, boolean included) {
		if (i == v.length) {
			System.out.println(sum + " " + included);
			return (sum == 0 && included);
		}

		boolean inc = subsetSumEasy(v, i + 1, sum + v[i], true);
		boolean exc = subsetSumEasy(v, i + 1, sum, included);

		return inc || exc;
	}

	/*
	 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
	 * int testCases = sc.nextInt(); while (testCases-- > 0) { int n = sc.nextInt();
	 * int[] v = new int[n]; for (int i = 0; i < n; i++) { v[i] = sc.nextInt(); }
	 * 
	 * if (subsetSumEasy(v, 0, 0, false)) { System.out.println("Yes"); } else {
	 * System.out.println("No"); } }
	 * 
	 * }
	 */

}
