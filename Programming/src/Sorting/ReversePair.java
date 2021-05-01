package Sorting;

import java.util.Arrays;

public class ReversePair {

	public static void main(String[] args) {
		int arr[] = { 14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549, 57512, 33137,
				81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190, 94365, 58869, 20611 };
		System.out.println(new ReversePair().solve(arr));
	}

	public int solve(int[] A) {
		return mergeSort(A, 0, A.length);
	}

	public int mergeSort(int[] arr, int start, int end) {
		Long count = 0l;
		if (start < end - 1) {
			int mid = (start + end) / 2;

			int left[] = Arrays.copyOfRange(arr, 0, mid);
			int right[] = Arrays.copyOfRange(arr, mid, end);
			count += mergeSort(left, 0, left.length);
			count += mergeSort(right, 0, right.length);
			count += merge(arr, left, right);
		}
		return count.intValue();
	}

	public long merge(int arr[], int left[], int right[]) {

		int l = 0;
		int r = 0;
		int k = 0;
		Long ans = 0l;

		int j = 0;
		
		/**
		 * [a0 , a1 , a3 ....... aN]
		 * [b0 , b1 , b3 ....... bN]
		 * 
		 * compare a0 [] - in B array [from start till it satisfies the condition]
		 * a0 > 2 * b[0...n]
		 * */
		
		
		for (int i = 0; i < left.length; i++) {
			long value = 0l;
			for (; j < right.length; j++) {
				if (left[i] <= (2 * right[j])) {
					break;
				}
				value++;
			}
			ans += (value + (j - value));
		}

		while (l < left.length && r < right.length) {

			if (left[l] <= right[r]) {
				arr[k] = left[l];
				l++;
				k++;
			} else {
				arr[k] = right[r];
				r++;
				k++;
			}

		}

		while (l < left.length) {
			arr[k] = left[l];
			l++;
			k++;
		}

		while (r < right.length) {
			arr[k] = right[r];
			r++;
			k++;
		}
		return ans;
	}

}
