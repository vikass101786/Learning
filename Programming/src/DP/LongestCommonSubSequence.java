package DP;

import java.util.Scanner;

public class LongestCommonSubSequence {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		char str1Arr [] = str1.toCharArray();
		String str2 = sc.next();
		char str2Arr [] = str2.toCharArray();
		int count1 = 0;
		int count2 = 0;
		int totalCount = 0;
		int startPointer = 0;
		System.out.println(longestCommonSubSequence(str1Arr , str2Arr, count1 , count2 , totalCount , startPointer));
	}

	private static int longestCommonSubSequence(char [] str1Arr, char [] str2Arr, int count1, int count2 , int totalCount , int startPointer)
	{
		
		if(str1Arr.length <= count1) {
			return totalCount;
		}
		
		if(str2Arr.length <= count2) {
			return longestCommonSubSequence(str1Arr, str2Arr, count1+1, startPointer , totalCount , startPointer);
		}
		
		if((str2Arr.length > count2) && str1Arr[count1] == str2Arr[count2]) {
			 startPointer = count2;
			return longestCommonSubSequence(str1Arr, str2Arr, count1+1, count2+1, totalCount+1 , startPointer);
		}
		
		return longestCommonSubSequence(str1Arr, str2Arr, count1, count2+1, totalCount , startPointer);
		
		//return totalCount;
	}
	
}	
