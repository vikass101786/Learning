package ProblemSolving;

public class ClosestMinMax {

	public static void main(String[] args) {
		int arr[] = {377, 448, 173, 307, 108};
		System.out.println(solve(arr));
	}

	public static int solve(int[] A) {

		Integer max_ele = Integer.MIN_VALUE;
		int max_index = -1;
		Integer min_ele = Integer.MAX_VALUE;
		int min_index = -1;
		Integer ans = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {
			if (A[i] > max_ele) {
				max_ele = A[i];
			}
			if (A[i] < min_ele) {
				min_ele = A[i];
			}
		}

		for (int i = 0; i < A.length; i++) {
			boolean flag = false;
			if (A[i] == max_ele) {
				max_index = i;
				flag = true;
			}

			if (A[i] == min_ele) {
				min_index = i;
				flag = true;
			}

			if (flag && max_index != -1 && min_index != -1) {
				int diff = Math.abs(max_index - min_index);
				if (ans > diff) {
					ans = diff;
				}
			}

		}

		System.out.println(max_ele + " " + min_ele);
		return ans+1;
	}
}
