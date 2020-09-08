package DP;

import java.util.Scanner;

public class ReduceANumberToOne {
	
	static int dpArr [];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opArr [] = {1,2,3};
		int num = sc.nextInt();
		dpArr = new int[num];
		int count = 0;
		countStep(num,opArr,count);
	}

	private static void countStep(int num , int [] arr , int count) {
		// TODO Auto-generated method stub
		if(num == 1) {
			System.out.println(count);
			return;
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			//if(dpArr[num] == 0) {
			int output = performOperation(num,arr[i]);
			if(output > 0) {
				countStep(output, arr, count+1);
				//dpArr[num] = count;
			}
		  }
			
		}
	//}

	private static int performOperation(int num, int i) {
		// TODO Auto-generated method stub
		switch(i) {
		case 1:
			return (num%3) == 0 ? (num/3) : -1;
		case 2:
			return (num%2) == 0 ? (num/2) : -1;

		case 3: 
			return num -1;
		default :
			return -1;
	}
}	
}
