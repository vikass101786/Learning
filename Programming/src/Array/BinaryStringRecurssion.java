package Array;

import java.util.Scanner;

public class BinaryStringRecurssion {
	
	// Two one should not be adjacent
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-- > 0) {
			int num = sc.nextInt();
			System.out.println(countBinNum(num,1,0));
		}
	}

	private static int countBinNum(int num,int start, int lastDigit) {
		if(num == start && lastDigit == 0) return 2;
		
	    if(num == start && lastDigit == 1) return 1;
			 
		
		if(lastDigit == 0) 
			return countBinNum(num,start+1, 0) + countBinNum(num,start+1, 1);
		else
			return countBinNum(num,start+1, 0);
	}
}
