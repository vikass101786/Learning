package DP;

import java.util.Scanner;

public class Max_Sum_K_Partition {
	
	
	/*
	 * 
	 * Agarwal has a habit of creating Ajeeb Samasya as usual and Shubham always 
	 * comes to his rescue. This is time he has created another samasya which is 
	 * as follows. Read carefully! Shubham has an array of N integers and an integer
	 *  K. He wants to create a subsequence of this array with some conditions applied.
	 * He builds ceil(N/K) blocks of this array with size of each block as [i∗K+1,min((i+1)∗k,N)]
	 * for 0≤i≤N/K. For two consecutive integers in this subsequence, he wants the integers to be
	 * of two different blocks. (It is not a compulsion to have one integer from each block).
	 * Also, lets say the indexes of any two integers of this subsequence be i and j, then
	 * he wants |i−j| != K. Shubham takes the sum of integers in the subsequence. He wonders what
	 * can be the maximum sum obtained? Help shubham in this samasya.
	 * 
	 * 
	 * Input Format
	 * 
	 * First line contains two space separated integers : N and K Second line contains N space separated integers : A1, A2,…, AN
	 * 
	 *   Constraints
	 *   
	 *   1 ≤ N ≤ 2∗10^6
	 * 
	 *   1 ≤ K ≤ N
	 *   
	 *   −10^9 ≤ Ai ≤ 10^9
	 *   
	 *   
	 *   Output Format
	 * 
	 *   print a single integer describing maximum sum that can be obtained.
	 *   
	 *   Sample Input
	 *   
	 *   6 5
	 *   
	 *   5 4 3 2 1 -1
	 *   
	 *   Sample Output
	 *   
	 *   5
	 */
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		long k = sc.nextInt();
		long arr[] = new long[length];
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(findMaxSum(arr, k));
	}

	public static long findMaxSum(long[] arr, long K) {
		long auxArr[] = new long[arr.length];

		long max_value_1 = 0;
		long max_value_2 = 0;
		long max_val_index = 0;
		long current_max_1 = 0;
		long current_max_2 = 0;
		long current_max_val_index = 0;
		long K1 = 0;
		auxArr[0] = 0;

		for (int i = 0; i < arr.length; i++) {
			if ((i - max_val_index) == K) {
				auxArr[i] = arr[i] >= 0 ? (arr[i] + max_value_2) : max_value_2;
			} else {
				auxArr[i] = arr[i] >= 0 ? (arr[i] + max_value_1) : max_value_1;
			}

			if (auxArr[i] > current_max_1) {
				current_max_2 = current_max_1;
				current_max_1 = auxArr[i];
				current_max_val_index = i;
			} else if (auxArr[i] > current_max_2) {
				current_max_2 = auxArr[i];
			}
			K1++;
			if (K == K1) {
				max_value_1 = current_max_1;
				max_value_2 = current_max_2;
				max_val_index = current_max_val_index;
				K1 = 0;
			}
		}
		max_value_1 = current_max_1;
		return max_value_1;
	}
}
