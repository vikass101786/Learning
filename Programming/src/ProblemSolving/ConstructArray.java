package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructArray {

	public static void main(String[] args) {
		System.out.println(new ConstructArray().solve(5, 20, 50));
	}

	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	Integer min_ans;
	int start = -1;
	int gl_diff = -1;

	public int solve(final int A, final int B, final int C) {
		min_ans = C;
		int diff = C - B;
		int sqrt = (int) Math.sqrt(diff);
		for (int i = 1; i <= sqrt; i++) {
			ArrayList<Integer> list = null;
			if ((diff % i) == 0) {
				list = new ArrayList<>();
				list.add(i);
				list.add(diff / i);
				int main_arr [] = Arrays.copyOf(findMaxValue(A, B, C, list), 3);
				if (min_ans >=  main_arr[2]) {
					start = main_arr[1];
					gl_diff = main_arr[0];
				}
			}
		}
		return min_ans;
	}

	int [] findMaxValue(int A, int B, int C, ArrayList<Integer> list) {
		int arr[] = new int[3];
		arr[2] = Integer.MAX_VALUE;
		Integer min = Integer.MAX_VALUE;
		for (Integer value : list) {
			int current_num = C;
			int num = A-1;
			while (current_num > 0 && num > 0) {
				current_num -= value;
				if (current_num > 0) {
					num--;
				}
			}
			if (current_num != 0 && current_num < B) {
				if (min > (C+ (value * num))) {
					min = C+ (value * num);
					arr[0] = value;
					arr[1] = C - (((A-num)-1)*value);
					arr[2] = min;
				}
			}
		}
		return arr;
	}

}
