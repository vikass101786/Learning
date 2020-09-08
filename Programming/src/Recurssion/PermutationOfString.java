package Recurssion;

import java.util.Scanner;

public class PermutationOfString {
	
	static void permute(char in [] , int i) {
		if(in[i] == '\0') {
			System.out.println(in);
			return;
		}
		
		for (int k = i ; in[k] != '\0' ; k++) {
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
		char[] in = new char[100];
	    int n = sc.nextInt();
	    for(int i = 0 ; i < n ; i++) {
	    	in [i] = sc.next().charAt(0);
	    }
	    System.out.println(in);
	    permute(in , 0);
	}

}
