package ProblemSolving;

import java.util.Arrays;

public class PermutationRank {
	
	public static void main(String[] args) {
		//DTNGJPURFHYEW
		System.out.println(new PermutationRank().findRank("acBAcbC"));
	}
	
	 public int findRank(String A) {
		 
		 char input [] = A.toCharArray();
		 Arrays.sort(input);
		
		 String new_input = new String(input);
		 
		 int arr [] = new int [256];
		 int count = 1;
		 for (int i = 0 ; i < new_input.length() ; i++) {
			 arr [new_input.charAt(i)] = count;
			 count++;
		 }
		 
		 int weight [] = new int [256];
		 
		 for (int i = 0 ; i < A.length() ; i++) {
			 int current_val = 0;
			  for (int k = i+1 ; k < A.length() ; k++) {
				  if (arr[A.charAt(i)] > arr[A.charAt(k)]) {
					  current_val++;
				  }
			  }
			  weight[A.charAt(i)] = current_val;
		 }
		 
		 int fact = 1;
		 int value = 1;
		 int ans = 0;
		 for (int i = A.length() -1 ; i >= 0 ; i--) {
			 if ( i != A.length()-1) {
				 value++;
			 }
			 ans += (fact * weight[A.charAt(i)]) % 1000003;
			 fact = (fact * value)% 1000003;
		 }
		 return (ans + 1) % 1000003;
	 }
}		
