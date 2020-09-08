package Array;

import java.util.Scanner;

public class BInaryStringTopDown {
	//Two one should not be adjacent
	// Bottom Up
	// This problem can be solved using fibonnaci series as well 
	
	static int dpArr [][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-- > 0) {
			int num = sc.nextInt();
			dpArr = new int [2][num+1];
			dpArr[0][1] = dpArr[1][1] = 1;
			System.out.println(countBinaryNum(num));
		}
	}

	private static int countBinaryNum(int num) {
		// TODO Auto-generated method stub
		
		for (int i = 2 ; i <= num ; i++) {
			dpArr[0][i] = dpArr[0][i-1]+dpArr[1][i-1];
			dpArr[1][i] = dpArr[0][i-1];
		}
		
		return dpArr[0][num]+dpArr[1][num];
	}
	
	
}
