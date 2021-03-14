package ProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		int A[] = { 24831, 53057, 19790, -10679, 77006, -36098, 75319, -45223, -56760, -86126, -29506, 76770, 29094,
				87844, 40534, -15394, 18738, 59590, -45159, -64947, 7217, -55539, 42385, -94885, 82420, -31968, -99915,
				63534, -96011, 24152, 77295 };
		maxset(A);
	}

	public static int[] maxset(int[] A) {
		List<Integer> list = new ArrayList<Integer>();
		Long max_sum = Long.MIN_VALUE;
		TreeMap<Long, List<Integer>> map = new TreeMap<>();
		Long current_sum = 0l;
		for (int i = 0; i <= A.length; i++) {
			if (i == A.length || A[i] < 0) {
				if (map.get(current_sum) == null) {
					map.put(current_sum, list);
				}
				if (current_sum > max_sum) {
					max_sum = current_sum;
				}
				current_sum = 0l;
				list = new ArrayList<>();
			} else if (i != A.length) {
				current_sum += A[i];
				list.add(A[i]);
			}
		}

		int arr[] = new int[map.get(max_sum).size()];
		List<Integer> travList = map.get(max_sum);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = travList.get(i).intValue();
		}
		return arr;
	}
}
