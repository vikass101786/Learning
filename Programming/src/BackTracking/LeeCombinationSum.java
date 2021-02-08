package BackTracking;

import java.util.List;

public class LeeCombinationSum {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 6, 7 };
		int target = 7;
		combinationSum1(arr, target, 0, "");
	}

	static List<List<Integer>> combinationSum(int[] candidates, int target) {

		return null;
	}

	static void combinationSum1(int[] candidates, int target, int index, String answer) {
		if (target == 0) {
			System.out.println(answer);
			return;
		}
		if (target < 0)
			return;
		for (int i = index; i < candidates.length; i++)
			combinationSum1(candidates, target - candidates[i], i, answer + " " + candidates[i]);
	}
}
