package Sorting;

public class SingleElementInSortedArray {

	/**
	 * Single Element in a Sorted Array Problem Description
	 * 
	 * Given a sorted array of integers A where every element appears twice except
	 * for one element which appears once, find and return this single element that
	 * appears only once.
	 * 
	 * NOTE: Users are expected to solve this in O(log(N)) time.
	 * 
	 * 
	 * 
	 * Problem Constraints 1 <= |A| <= 100000
	 * 
	 * 1 <= A[i] <= 10^9
	 * 
	 * 
	 * 
	 * Input Format The only argument given is the integer array A.
	 * 
	 * 
	 * 
	 * Output Format Return the single element that appears only once.
	 * 
	 * 
	 * 
	 * Example Input Input 1:
	 * 
	 * A = [1, 1, 7] Input 2:
	 * 
	 * A = [2, 3, 3]
	 * 
	 * 
	 * Example Output Output 1:
	 * 
	 * 7 Output 2:
	 * 
	 * 2
	 * 
	 * 
	 * Example Explanation Explanation 1:
	 * 
	 * 7 appears once Explanation 2:
	 * 
	 * 2 appears once
	 * 
	 */

	public int solve(int[] A) {

		int left = 0;
		int right = A.length - 1;

		while (left <= right) {

			int mid = (right - left) / 2 + left;

			if ((mid + 1 < A.length && A[mid] != A[mid + 1]) && (mid - 1 >= 0 && A[mid] != A[mid - 1])) {
				return A[mid];
			}

			if ((mid == 0) && (mid + 1 < A.length && A[mid] != A[mid + 1])) {
				return A[mid];
			}

			if ((mid == A.length - 1) && (mid - 1 >= 0 && A[mid] != A[mid - 1])) {
				return A[mid];
			}

			if ((mid + 1 < A.length && A[mid] == A[mid + 1]) && ((mid & 1) == 1)) {
				right = mid - 1;
			} else if ((mid - 1 >= 0 && A[mid] == A[mid - 1]) && ((mid & 1) != 1)) {
				right = mid - 1;
			} else if ((mid + 1 < A.length && A[mid] == A[mid + 1]) && ((mid & 1) != 1)) {
				left = mid + 1;
			} else if ((mid - 1 >= 0 && A[mid] == A[mid - 1]) && ((mid & 1) == 1)) {
				left = mid + 1;
			}

		}
		return -1;
	}

}
