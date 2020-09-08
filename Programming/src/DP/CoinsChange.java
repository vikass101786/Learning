package DP;

import java.util.Scanner;

public class CoinsChange {

	/*
	 * Let's define a new game of snakes and ladders. There is only one dimension of
	 * n cells. Each cell either contains a snake or ladder. One can simply take a
	 * jump of not more than k cells. A person cannot step on a snake. However, s/he
	 * can jump over a snake. Alice is excited to play this game and is asking you
	 * to calculate the number of ways to finish the game. Game starts at 1st cell
	 * and ends at the nth cell. It is guaranteed that there is a ladder at the 1st
	 * cell. Since the number can be large, output the answer modulo (109+7).
	 * 
	 * Input Format First line contains 2 integers N and K, denoting the number of
	 * cells and the maximum possible jump respectively. The next line contains N
	 * integers, x1, x2,…., xN, where xi is either 0 or 1. xi=0 denotes that there
	 * is a ladder in ith cell, xi=1 denotes that there is a snake in ith cell.
	 * 
	 * Constraints 1<=N<=10^4 1<=K<=10^4 0<=xi<=1
	 * 
	 * Output Format Output a single integer denoting the number of ways to finish
	 * the game modulo (109+7).
	 * 
	 * Sample Input 5 2 0 0 0 1 0 Sample Output 2
	 * 
	 * Explanation There are 2 ways to reach the 5th cell - [1,2,3,5] and [1,3,5].
	 * 
	 * 
	 */
	public static int dpArr [];

    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr [] = new int [n+1];
		for (int i = 1 ; i < n+1 ; i++) {
			arr[i] = sc.nextInt();
		}
		dpArr = new int [n+1];
		System.out.println(totalSteps(arr,k));
    }

	public static int totalSteps(int [] arr , int k) {
		dpArr[1] = 1;
		for (int i = 2 ; i < arr.length ; i++) {
			if(arr [i] == 0) {
				int sum = 0;
				for (int j = k ; j > 0 && (i-j) >= 0 ; j--){
					sum += dpArr[i - j] % 1000000007;
				}
				dpArr[i] = sum;
			}
		}
		return dpArr[dpArr.length - 1];
	}
}
