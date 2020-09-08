package Recurssion;

import java.util.Scanner;

public class BinaryNumGen {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		char arr [] = new char [len];
		char bin [] = {'0','1'};
		for (int i = 0 ; i < bin.length ; i++) {
			arr[0] = bin[i];
			printBinaryNum(arr, 1, bin, 0);
		}
	}

	private static void printBinaryNum(char[] arr, int i,char[] bin, int j) {
		// TODO Auto-generated method stub
		if(i == arr.length) {
			System.out.println(arr);
			return;
		}
		
		 if(arr[i-1] == '1') {
			arr[i] = bin[j];
			printBinaryNum(arr, i+1, bin, j);
		} else if(arr[i-1] == '0') {
			arr[i] = bin[j];
			printBinaryNum(arr, i+1, bin, j);
			printBinaryNum(arr, i+1, bin, j+1);
		}
	}

}
