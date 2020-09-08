package DP;

import java.util.Scanner;

public class ReduceANumberToOne2 {

	
	// Bottom Up	
	
		static int dpArr [];
		
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			dpArr = new int[1000];
			System.out.println(reduceToOne(num));
		}

		private static int reduceToOne(int num) {
			dpArr[0] = 0 ; dpArr[1] = 0 ; dpArr[2] = 1;	dpArr[3] = 1;	
			
			for(int i = 4 ; i <= num ; i++ ) {
				int q1 = Integer.MAX_VALUE;
				int q2 = Integer.MAX_VALUE;
				int q3 = Integer.MAX_VALUE;
				
				if(i%3 == 0) q1 = 1+dpArr[i/3];
				if(i%2 == 0) q2 = 1+dpArr[i/2];
				q3 = 1+dpArr[i -1];
				
				dpArr[i] = Math.min(q1, Math.min(q2, q3));
			}
			return dpArr[num];
		}
	
	
}
