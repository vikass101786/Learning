package DP;

import java.util.Scanner;

public class ReduceNumberToOne1 {
	
	// Memmoization	
	
		static int dpArr [];
		
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int opArr [] = {1,2,3};
			int num = sc.nextInt();
			dpArr = new int[1000];
			int count = 0;
			System.out.println(reduceToOne(num));
		}

		private static int reduceToOne(int num) {
			if(num == 1) {
				return 0;
			}
			int q1 = Integer.MAX_VALUE, q2 = Integer.MAX_VALUE, q3 = Integer.MAX_VALUE; 
			
			if(dpArr[num] == 0) {
			if(num % 3 == 0) q1 = 1+ reduceToOne(num/3);
			if(num % 2 == 0) q2 = 1+ reduceToOne(num/2);
			q3 = 1+ reduceToOne(num-1);
			dpArr[num] = Math.min(q1, Math.min(q2, q3));
			}
			return dpArr[num];
			
		}
	
	}


