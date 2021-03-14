package ProblemSolving;

import java.util.Arrays;

public class MinDiff {
	
	public static void main(String[] args) {
		int arr [] = {5, 17, 100, 11};
		System.out.println(solve(arr));
	}
	
	 public static int solve(int[] A) {
	        Arrays.sort(A);
	        
	        int diff = Math.abs(A[0] - A[1]);
	        
	        for (int i = 1 ; i < A.length-1 ; i++) {
	            int current_diff = Math.abs(A[i] - A[i+1]);
	            if (diff > current_diff) {
	                diff = current_diff;
	            }
	        }
	        return diff;
	    }
}
