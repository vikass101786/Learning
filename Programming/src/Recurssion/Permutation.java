package Recurssion;

import java.util.Scanner;

public class Permutation {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String toPermute = sc.next();
		char arrToPermute[] = toPermute.toCharArray();
		int currentIndex = 0;
		printPermute(arrToPermute, currentIndex);
		 
		//System.out.println(15 & (~(1|0|0)));
	}

	private static void printPermute(char[] arrToPermute, int currentIndex) {
		// TODO Auto-generated method stub
		if(currentIndex == arrToPermute.length) {
			System.out.print(arrToPermute);
			 System.out.println("==============="); 
			 
			return;
		}
		
		for(int i = currentIndex ; i < arrToPermute.length ; i++) {
			/*
			 * System.out.print("printPermute( "); System.out.print(arrToPermute);
			 * System.out.print( " , " + i + " , " + currentIndex +" )");
			 */
			swap(arrToPermute,i,currentIndex);
			/*
			 * System.out.println(); System.out.print("printPermute( ");
			 * System.out.print(arrToPermute); System.out.print( " , " + i + " , " +
			 * currentIndex + " ) after swapping"); System.out.println();
			 */
			printPermute(arrToPermute, currentIndex+1);
			swap(arrToPermute,i,currentIndex);
		}
	}

	private static void swap(char[] arrToPermute, int i, int currentIndex) {
		// TODO Auto-generated method stub
		char temp = arrToPermute[i];
		arrToPermute[i] = arrToPermute[currentIndex];
		arrToPermute[currentIndex] = temp;
	}
	
}
