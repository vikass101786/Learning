package Recurssion;

import java.util.Arrays;
import java.util.Scanner;

public class PowerSetOfStrings {
public static int k = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char charArr [] = str.toCharArray();
		Arrays.sort(charArr); 
		str = new String(charArr);
		String arr [] = new String[100000];
		Arrays.fill(arr, "");
		printSubSequence(str,0 ,"",arr);
		Arrays.sort(arr);
		for (int i = 0 ; i < arr.length ; i++) {
			if(!arr[i].equals("")) {
			System.out.println(arr[i] + " ");
			}
		}
	}

	private static void printSubSequence(String str, int i , String answe , String arr []) {
		if(i == str.length()) {
			if(!answe.equals("")) {
			arr[k] = answe; k++;
			}
			return;
		}
		
		printSubSequence(str, i+1, answe + str.charAt(i),arr);
		printSubSequence(str, i+1, answe,arr);
	}
	
}
