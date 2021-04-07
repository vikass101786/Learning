package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimizeDifference {


	public static void main(String[] args) {
		int A[] = { 1, 1, 7 };
		int B = 7;
		System.out.println(new MinimizeDifference().solve(A, B));
	}

	public int solve(int[] A, int B) {
		Arrays.sort(A);
		Map<Integer, Integer> map = new HashMap<>();
		Integer value = 0;
		for (int i = 0; i < A.length; i++) {
			value = map.putIfAbsent(A[i], 1);
			if (value != null) {
				map.put(A[i], value + 1);
			}
		}

		int min = A[0];
		int max = A[A.length - 1];

		while (B-- > 0) {
			if ((max - min) != 0) {
				if (map.get(min) == 1) {
					A[0] += 1;
					value = map.putIfAbsent(A[0], 1);
					if (value != null) {
						map.put(A[0], value + 1);
					}
				} else if (map.get(max) == 1) {
					A[A.length - 1] -= 1;
					value = map.putIfAbsent(A[A.length - 1], 1);
					if (value != null) {
						map.put(A[A.length - 1], value + 1);
					}
				} else {
					if (map.get(min) <= map.get(max)) {
						A[0] += 1;
						value = map.putIfAbsent(A[0], 1);
						if (value != null) {
							map.put(A[0], value + 1);
						}
					} else {
						A[A.length - 1] -= 1;
						value = map.putIfAbsent(A[A.length - 1], 1);
						if (value != null) {
							map.put(A[A.length - 1], value + 1);

						}
						;
					}
				}
				Arrays.sort(A);
				min = A[0];
				max = A[A.length - 1];
			}
		}
		return (max - min);
	}
}
