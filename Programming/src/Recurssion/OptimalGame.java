package Recurssion;

import java.util.Scanner;

public class OptimalGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();

		while (testCases-- > 0) {
			int length = sc.nextInt();
			int arr[] = new int[length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(optimalGame(0, arr.length - 1, arr));
		}
	}

	private static int optimalGame(int i, int j, int[] arr) {
		// TODO Auto-generated method stub
		if (i > j) {
			return 0;
		}

		int left = arr[i] + Math.min(optimalGame(i + 1, j - 1, arr), 
									optimalGame(i + 2, j, arr));
		int right = arr[j] + Math.min(optimalGame(i + 1, j - 1, arr),
									optimalGame(i, j - 2, arr));

		return Math.max(left, right);
	}

}
