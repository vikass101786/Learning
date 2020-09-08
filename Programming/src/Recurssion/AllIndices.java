package Recurssion;

import java.util.Scanner;

public class AllIndices {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int arr [] = new int[length];
		for(int i=0 ; i < length ; i++) {
			arr[i] = sc.nextInt();
		}
		int matchNum = sc.nextInt();
		
		indicesPrb(arr,matchNum,0);
	}

	private static void indicesPrb(int[] arr, int matchNum, int i) {
		// TODO Auto-generated method stub
		if(i == arr.length) {
			return;
		}
		
		int x = -1;
		
		if(arr[i] == matchNum) {
			x = i;
		}
			indicesPrb(arr, matchNum, i+1);
		
		
		if(x != -1) {
			System.out.print(x + " ");
		}
		
	}
	
}
