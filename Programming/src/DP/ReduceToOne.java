package DP;

import java.util.Arrays;
import java.util.Scanner;

public class ReduceToOne {

	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		arr = new int[num+1];
		Arrays.fill(arr, -1);
		System.out.println(reduceToOne(num));
	}

	public static int reduceToOne(int num) {

		if (num == 1) {
			return 0;
		}
		int div3 = Integer.MAX_VALUE, div2 = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;
		if (arr[num] != -1) {
			return arr [num];
		} else {
			if (num % 3 == 0)
				div3 = reduceToOne(num / 3) + 1;
			if (num % 2 == 0)
				div2 = reduceToOne(num / 2) + 1;
			min1 = reduceToOne(num - 1) + 1;
		}
		
		arr[num] = Math.min(Math.min(div3, div2), min1);

		return arr[num];

	}

}
