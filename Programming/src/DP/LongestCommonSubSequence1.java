package DP;

import java.util.Scanner;

public class LongestCommonSubSequence1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		char str1Arr [] = str1.toCharArray();
		String str2 = sc.next();
		char str2Arr [] = str2.toCharArray();
		int count1 = 0;
		int count2 = 0;
		System.out.println(longestCommonSubq(str1Arr,str2Arr,count1,count2));
	}

	private static int longestCommonSubq(char[] str1Arr, char[] str2Arr, int count1, int count2) {
		// TODO Auto-generated method stub
		
		if(str1Arr.length <= count1) {
			return 0;
		}
		
		if(str2Arr.length <= count2) {
			return 0;
		}
		
		if(str1Arr[count1] == str2Arr[count2])
		{
			 return longestCommonSubq(str1Arr, str2Arr, count1+1, count2+1)+1;
		}
		return Math.max(longestCommonSubq(str1Arr, str2Arr, count1, count2+1), 
				longestCommonSubq(str1Arr, str2Arr, count1+1, count2));
		
	}

}
