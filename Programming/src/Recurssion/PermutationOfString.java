package Recurssion;

import java.util.Scanner;

public class PermutationOfString {
	
	static void permute(char in [] , int i) {
		if(i == in.length) {
			System.out.println(in);
			return;
		}
		
		for (int k = 0 ; k < in.length ; k++) {
			swap(in , i , k);
			permute(in, i+1);
			swap(in , i , k);
		}	
	}
	
	
	
	private static void swap(char [] in , int i, int k) {
		char temp = in [i];
		in[i] = in [k];
		in [k] = temp;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	   String in = sc.next();
	    //System.out.println(in);
	    permute(in.toCharArray() , 0);
	}

}
