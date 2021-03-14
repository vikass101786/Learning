package ProblemSolving;

import java.util.Arrays;

public class SortTheUnSortedArray {

	public static void main(String[] args) {
		int arr[] = {70, 21, 7, 64, 44, 79, 50, 89, 68, 23, 20, 50, 65, 64, 48, 3, 46, 87};
		Arrays.sort(arr);
		System.out.println(solve(arr));
	}

	public static int solve(int[] A) {
		int B [] = Arrays.copyOf(A, A.length);
		Arrays.sort(B);
		int start = -1;
		int end = -1;
		
		for(int i = 0 ; i < A.length ; i++) {
			if (A[i] != B[i]) {
				start = i;
				break;
			} 
		}
		
		for(int i = A.length-1 ; i >= 0 ; i--) {
			if (A[i] != B[i]) {
				end = i;
				break;
			} 
		}
		return (end - start)+1;
	}
}
