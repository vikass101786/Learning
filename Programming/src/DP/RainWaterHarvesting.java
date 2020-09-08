package DP;

import java.util.Scanner;

public class RainWaterHarvesting {
	
	/*
	 * Apoorvaa has created an elevated roof. She wants to know how much water can she save during rain.
	 * Given n non negative integers representing the elevation map where width of every bar is 1, Find the maximum water that she can save.
	 * 
	 * So the total units of water she can save is 5 units
	 * 
	 * Input Format
	 * 
	 * First line contains an integer n. Second line contains n space separated integers representing the elevation map.
	 * 
	 * Constraints
	 * 
	 * 1 <= N <= 10^6
	 * 
	 * Output Format
	 * 
	 * Print a single integer containing the maximum unit of waters she can save.
	 * 
	 * Sample Input
	 * 
	 * 10
	 * 
	 * 0 2 1 3 0 1 2 1 2 1
	 * 
	 * Sample Output
	 * 
	 * 5
	 * 
	 * Explanation
	 * 
	 * Refer to the image for explanation. Count the number of cells having water in them.
	 * 
	 */
	
	public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr [] = new int [n];
		int leftArr [] = new int [n];
		int rightArr [] = new int [n]; 
		int prev = 0;
		for (int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
			leftArr[i] = Math.max(prev,arr[i]);
			//System.out.print(leftArr[i] + "");
			prev = leftArr[i];
		}
		System.out.println(maxWater(arr,leftArr,rightArr));
    }

	public static int maxWater(int [] arr,int [] leftArr,int [] rightArr) {
		int last = 0;
		for (int i = rightArr.length -1 ; i >= 0 ; i-- ) {
			rightArr[i] = Math.max(last,arr[i]); 
			last = rightArr[i];
			//System.out.print(rightArr[i] + "");
		}

		int sum = 0 ;

		for (int i = 0 ; i < arr.length ; i++) {
			sum += Math.min(leftArr[i],rightArr[i]) - arr[i];
		}
	 return sum;
	}
}
