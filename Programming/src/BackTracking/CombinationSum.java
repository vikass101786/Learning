package BackTracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/

public class CombinationSum {

	public static void main(String[] args) {
		int arr [] = {2,3,6,7};
		System.out.println(combinationSum(arr,7));
		System.out.println(combinationSum1(arr,7));
		int arr1 [] = {2,3,5};
		System.out.println(combinationSum(arr1,8));
		int arr2 [] = {2};
		System.out.println(combinationSum(arr2,1));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		combinationSumUtility(candidates, target,answer,temp,0);
		return answer;
	}
	public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		combinationSumUtility1(candidates, target,answer,temp,0);
		return answer;
	}

	private static void combinationSumUtility(int[] candidates, int target, List<List<Integer>> answer,
			List<Integer> temp, int vIdx) {
		// TODO Auto-generated method stub
		if(target == 0) {
			answer.add(new ArrayList<Integer>(temp));
			return;
		}
			
		if(target < 0) {
			return;
		}
		
		for (int i = vIdx ; i < candidates.length ; i++) {
			temp.add(candidates[i]);
			combinationSumUtility(candidates, target-candidates[i], answer, temp, i);
			temp.remove(temp.size()-1);
		}
		
	}
	private static void combinationSumUtility1(int[] candidates, int target, List<List<Integer>> answer,
			List<Integer> temp, int vIdx) {
		// TODO Auto-generated method stub
		if(target < 0 || candidates.length == vIdx) {
			return;
		}
		
		if(target == 0) {
			answer.add(new ArrayList<Integer>(temp));
			return;
		}
		
			temp.add(candidates[vIdx]);
			combinationSumUtility(candidates, target-candidates[vIdx], answer, temp, vIdx);
			temp.remove(temp.size()-1);
			combinationSumUtility(candidates, target, answer, temp, vIdx+1);
		
		
	}

}
