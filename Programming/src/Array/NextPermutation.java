package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(4, 3, 2, 1));
		System.out.println(new NextPermutation().nextPermutation(list));
	}

	public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {

		int idx = -1;

		for (int index = A.size() - 2; index >= 0; index--) {
			if (A.get(index) < A.get(index + 1)) {
				idx = index;
				break;
			}
		}

		if (idx == -1) {
			Collections.reverse(A);
		} else {
			int value = A.get(idx);
			int updatedValue = Integer.MAX_VALUE;
			int idx_1 = -1;
			for (int index = idx + 1; index < A.size(); index++) {
				if (A.get(index) >= value && A.get(index) <= updatedValue) {
					updatedValue = A.get(index);
					idx_1 = index;
				}
			}

			Collections.swap(A, idx, idx_1);
			int left = idx + 1;
			int right = A.size() - 1;

			while (left < right) {
				Collections.swap(A, left, right);
				left++;
				right--;
			}
		}

		return A;
	}
}
