package Stack;

import java.util.Stack;

public class MaxAndMin {

	/*
	 * MAX and MIN Problem Description
	 * 
	 * Given an array of integers A .
	 * 
	 * value of a array = max(array) - min(array).
	 * 
	 * Calculate and return the sum of values of all possible subarrays of A %
	 * 109+7.
	 * 
	 * 
	 * 
	 * Problem Constraints 1 <= |A| <= 100000
	 * 
	 * 1 <= A[i] <= 1000000
	 * 
	 * 
	 * 
	 * Input Format The first and only argument given is the integer array A.
	 * 
	 * 
	 * 
	 * Output Format Return the sum of values of all possible subarrays of A %
	 * 10^9+7.
	 * 
	 * 
	 * 
	 * Example Input Input 1:
	 * 
	 * A = [1] Input 2:
	 * 
	 * A = [4, 7, 3, 8]
	 * 
	 * 
	 * Example Output Output 1:
	 * 
	 * 0 Output 2:
	 * 
	 * 26
	 * 
	 * 
	 * Example Explanation Explanation 1:
	 * 
	 * Only 1 subarray exists. Its value is 0. Explanation 2:
	 * 
	 * value ( [4] ) = 4 - 4 = 0 value ( [7] ) = 7 - 7 = 0 value ( [3] ) = 3 - 3 = 0
	 * value ( [8] ) = 8 - 8 = 0 value ( [4, 7] ) = 7 - 4 = 3 value ( [7, 3] ) = 7 -
	 * 3 = 4 value ( [3, 8] ) = 8 - 3 = 5 value ( [4, 7, 3] ) = 7 - 3 = 4 value (
	 * [7, 3, 8] ) = 8 - 3 = 5 value ( [4, 7, 3, 8] ) = 8 - 3 = 5 sum of values %
	 * 10^9+7 = 26
	 * 
	 * 
	 */

	public int solve(int[] A) {

		Stack<Integer> stack = new Stack<>();
		int leftMostEleIndex = -1;
		int rightMostEleIndex = A.length;
		int mod = 1000_000_007;

		// find left nearest smallest number

		int lns[] = new int[A.length];

		for (int i = 0; i < A.length; i++) {

			while (!stack.isEmpty() && A[stack.peek()] >= A[i])
				stack.pop();

			lns[i] = stack.isEmpty() ? leftMostEleIndex : stack.peek();
			// System.out.print(lns[i] + " ");
			stack.add(i);
		}

		// System.out.println();

		// find right nearest smallest number

		int rns[] = new int[A.length];
		stack.clear();

		for (int i = A.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && A[stack.peek()] >= A[i])
				stack.pop();

			rns[i] = stack.isEmpty() ? rightMostEleIndex : stack.peek();
			// System.out.print(rns[i] + " ");
			stack.add(i);
		}

		// System.out.println();

		// find left nearest greatest number

		int lng[] = new int[A.length];
		stack.clear();

		for (int i = 0; i < A.length; i++) {

			while (!stack.isEmpty() && A[stack.peek()] <= A[i])
				stack.pop();

			lng[i] = stack.isEmpty() ? leftMostEleIndex : stack.peek();
			// System.out.print(lng[i] + " ");
			stack.add(i);
		}

		// System.out.println();

		// find right nearest greatest number

		int rng[] = new int[A.length];
		stack.clear();

		for (int i = A.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && A[stack.peek()] <= A[i])
				stack.pop();

			rng[i] = stack.isEmpty() ? rightMostEleIndex : stack.peek();
			// System.out.print(rng[i] + " ");
			stack.add(i);
		}

		// System.out.println();

		long ans = 0;

		for (int i = 0; i < A.length; i++) {

			int numberOfArrayStartIndexSmllest = i - lns[i];
			int numberOfArrayEndIndexSmllest = rns[i] - i;

			int numberOfArrayStartIndexGreatest = i - lng[i];
			int numberOfArrayEndIndexGreatest = rng[i] - i;

			ans -= (1l * numberOfArrayEndIndexSmllest * numberOfArrayStartIndexSmllest) * A[i];
			ans += (1l * numberOfArrayStartIndexGreatest * numberOfArrayEndIndexGreatest) * A[i];

		}

		return (int) (ans % mod);
	}

}
