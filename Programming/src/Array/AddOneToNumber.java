package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {

	/**
	 * Add One To Number Problem Description
	 * 
	 * Given a non-negative number represented as an array of digits, add 1 to the
	 * number ( increment the number represented by the digits ).
	 * 
	 * The digits are stored such that the most significant digit is at the head of
	 * the list.
	 * 
	 * NOTE: Certain things are intentionally left unclear in this question which
	 * you should practice asking the interviewer. For example: for this problem,
	 * following are some good questions to ask :
	 * 
	 * Q : Can the input have 0's before the most significant digit. Or in other
	 * words, is 0 1 2 3 a valid input? A : For the purpose of this question, YES Q
	 * : Can the output have 0's before the most significant digit? Or in other
	 * words, is 0 1 2 4 a valid output? A : For the purpose of this question, NO.
	 * Even if the input has zeroes before the most significant digit.
	 * 
	 * 
	 * Problem Constraints 1 <= size of the array <= 1000000
	 * 
	 * 
	 * 
	 * Input Format First argument is an array of digits.
	 * 
	 * 
	 * 
	 * Output Format Return the array of digits after adding one.
	 * 
	 * 
	 * 
	 * Example Input Input 1:
	 * 
	 * [1, 2, 3]
	 * 
	 * 
	 * Example Output Output 1:
	 * 
	 * [1, 2, 4]
	 * 
	 * 
	 * Example Explanation Explanation 1:
	 * 
	 * Given vector is [1, 2, 3]. The returned vector should be [1, 2, 4] as 123 + 1
	 * = 124.
	 */

	public static void main(String[] args) {
		int arr[] = { 0, 3, 7, 6, 4, 0, 5, 5, 5 };
		plusOne(arr);
		plusOne1(new ArrayList<Integer>(Arrays.asList(0, 3, 7, 6, 4, 0, 5, 5, 5)));
	}

	public static int[] plusOne(int[] A) {

		int carry = 1;
		for (int i = A.length - 1; i >= 0; i--) {
			int value = A[i] + carry;
			carry = (value >= 10) ? 1 : 0;
			A[i] = value % 10;
		}

		int trailingZeroCount = 0;
		int start = 0;
		for (int i = 0; i < A.length && carry != 1; i++) {
			if (A[i] != 0) {
				break;
			}
			start++;
			trailingZeroCount++;
		}

		int length = A.length - trailingZeroCount + (carry == 1 ? 1 : 0);

		int aux_arr[] = new int[length];

		int k = 0;
		if (carry == 1) {
			aux_arr[0] = 1;
			k++;
		}

		for (int i = start; i < A.length; i++) {
			aux_arr[k] = A[i];
			k++;
		}

		return aux_arr;
	}

	public static ArrayList<Integer> plusOne1(ArrayList<Integer> A) {

		int size = A.size();
		int carry = 1;

		for (int i = size - 1; i >= 0; i--) {
			int num = A.get(i) + carry;
			carry = num >= 10 ? 1 : 0;
			A.set(i, num % 10);
		}

		ArrayList<Integer> result = new ArrayList<>();

		if (carry == 1) {
			result.add(1);
		}

		for (Integer value : A) {
			if (value == 0 && result.size() == 0)
				continue;
			result.add(value);
		}

		return result;

	}

}
