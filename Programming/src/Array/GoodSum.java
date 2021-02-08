package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GoodSum {
	
	
	public static void main(String[] args) {
		int A [] = {1,2,3,4};
		
		System.out.println(new GoodSum().solve(A, 7));
	}

	public int solve(int[] A, int B) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			Integer value = map.putIfAbsent(A[i], 0);
			if (value != null)
				map.put(A[i], map.get(A[i] + 1));
		}

		int aux_arr[] = new int[map.size()];
		int k = 0;
		for (Entry<Integer, Integer> key : map.entrySet()) {
			aux_arr[k++] = key.getKey();
		}

		Arrays.sort(aux_arr);
		int l = 0;
		int r = aux_arr.length - 1;
		int count = 0;
		while (l < r) {
			int sum = aux_arr[l] + aux_arr[r];
			if (B == sum) {
				count++;
				count += map.get(aux_arr[l]);
				count += map.get(aux_arr[r]);
				l++;
				r--;
			} else if (B < sum) {
				r--;
			} else {
				l++;
			}
		}
		return count;
	}
}
