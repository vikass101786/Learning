package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class PermutationInArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
		System.out.println(new PermutationInArray().permute(input));
	}
	
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		HashSet<ArrayList<Integer>> arr = new HashSet<>();
		permute(A, 0, arr);
		return new ArrayList<ArrayList<Integer>>(arr);
	}

	void permute(ArrayList<Integer> A, int i, HashSet<ArrayList<Integer>> ans) {
		if (i == A.size()) {
			ans.add(new ArrayList<>(A));
			return;
		}

		for (int k = 0; k < A.size(); k++) {
			swap(A, i, k);
			permute(A, i + 1, ans);
			swap(A, i, k);
		}
	}

	private static void swap(ArrayList<Integer> A, int i, int k) {
		int temp = A.get(i);
		A.set(i, A.get(k));
		A.set(k, temp);
	}

}
