package Stack;

import java.util.Stack;

public class LargestRectangeInHistogram {

	/*
	 * 
	 * Largest Rectangle in Histogram Problem Description
	 * 
	 * Given an array of integers A .
	 * 
	 * A represents a histogram i.e A[i] denotes height of the ith histogram's bar.
	 * Width of each bar is 1.
	 * 
	 * Find the area of the largest rectangle formed by the histogram.
	 * 
	 * 
	 * 
	 * Problem Constraints 1 <= |A| <= 100000
	 * 
	 * 1 <= A[i] <= 1000000000
	 * 
	 * 
	 * 
	 * Input Format The only argument given is the integer array A.
	 * 
	 * 
	 * 
	 * Output Format Return the area of largest rectangle in the histogram.
	 * 
	 * 
	 * 
	 * Example Input Input 1:
	 * 
	 * A = [2, 1, 5, 6, 2, 3] Input 2:
	 * 
	 * A = [2]
	 * 
	 * 
	 * Example Output Output 1:
	 * 
	 * 10 Output 2:
	 * 
	 * 2
	 * 
	 * 
	 * Example Explanation Explanation 1:
	 * 
	 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4]. Explanation
	 * 2:
	 * 
	 * Largest rectangle has area 2.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		int arr[] = { 47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87,
				52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28,
				31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18,
				97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27 };
		System.out.println(new LargestRectangeInHistogram().largestRectangleArea(arr));
	}

	public int largestRectangleArea(int[] A) {

		int left[] = new int[A.length];
		int right[] = new int[A.length];

		int low = -1;
		int high = A.length;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < A.length; i++) {
			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}

			left[i] = stack.isEmpty() ? low : stack.peek();
			stack.add(i);
		}

		stack.clear();

		for (int i = A.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}

			right[i] = stack.isEmpty() ? high : stack.peek();
			stack.add(i);
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			int value = (right[i] - left[i] - 1) * A[i];
			max = Math.max(value, max);
		}

		return max;

	}
}
