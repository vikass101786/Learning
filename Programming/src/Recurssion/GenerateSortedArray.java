package Recurssion;

import java.util.Scanner;

public class GenerateSortedArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len1 = sc.nextInt();
		int len2 = sc.nextInt();
		int arr1 [] = new int [len1];
		int arr2 [] = new int [len2];
		
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		
		generateSortedPairs(arr1,arr2,false,0,0,0,"");
		
	}

	private static void generateSortedPairs(int[] arr1, int[] arr2, boolean isB , int A , int B,int currentNum, String answer) {
		// TODO Auto-generated method stub
		
		if(!isB && !answer.equals("")) {
			System.out.println(answer);
		}
		
		if(A >= arr1.length && B >= arr2.length) {
			return;
		}
		
		if(A < arr1.length)
		if (!isB && arr1[A] > currentNum) {
			generateSortedPairs(arr1, arr2, true, A+1, B, arr1[A] ,answer+" "+ arr1[A]);
		} else if (!isB) {
			generateSortedPairs(arr1, arr2, isB, A+1, B, currentNum ,answer);
		}
		
		if(B < arr2.length)
		if (isB && arr2[B] > currentNum) {
			generateSortedPairs(arr1, arr2, false, A, B+1, arr2[B] ,answer+" "+ arr2[B]);
		} else if (isB) {
			generateSortedPairs(arr1, arr2, isB, A, B+1, currentNum ,answer);
		}
		
	}
	
	

}
