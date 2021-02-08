package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	
	List<List<Integer>> answer = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		System.out.println(new CombinationSum3().combinationSum3(3, 7));
		System.out.println(new CombinationSum3().combinationSum3(3, 9));
		System.out.println(new CombinationSum3().combinationSum3(4, 1));
		System.out.println(new CombinationSum3().combinationSum3(3, 2));
		System.out.println(new CombinationSum3().combinationSum3(9, 45));
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> list = new ArrayList<Integer>();
		combinationSum3Utility(k, n, 1, list);
		return answer;
	}
	
	public void combinationSum3Utility(int k , int n , int vIdx, List<Integer> temp) {
		
		if (n == 0 && k == 0) {
			answer.add(new ArrayList<Integer>(temp));
			return;
		}
		
		if (n < 0 || k < 0) {
			return;
		}
		
		for (int i = vIdx ; i <= 9 ; i++ ) {
			temp.add(i);
			combinationSum3Utility(k-1, n-i, i+1, temp);
			temp.remove(temp.size() -1);
		}
	}
	
	public void combinationSum3Utility1(int k , int n , int vIdx, int [] arr, String answer) {
		
		if (n == 0 && k == 0) {
			System.out.println(answer);
			return;
		}
		
		if (n < 0 || k < 0) {
			return;
		}
		
		for (int i = vIdx ; i <= 9 ; i++ ) {
			combinationSum3Utility1(k-1, n-i, i+1, arr, answer +" "+i);
		}
	}

}
