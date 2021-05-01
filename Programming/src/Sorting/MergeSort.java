package Sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 6, 12, 10, 17, 10, 22, 9, 19, 21, 31, 26, 8};
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr, 0, arr.length);
		System.out.println(" == > " + ms.count);
		 ms.printArr(arr);
	}
	
	public void printArr (int [] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
	int count = 0;

	public void mergeSort(int[] arr, int start, int end) {
		if (start < end-1 && arr.length > 0) {
			int mid = (start + end) / 2;

			int left[] = Arrays.copyOfRange(arr, 0, mid);
			int right[] = Arrays.copyOfRange(arr, mid, end);
			 mergeSort(left, 0, left.length);
			mergeSort(right, 0, right.length);
			count += merge(arr, left, right);
		}
	}

	public int merge(int arr[], int left[], int right[]) {

		int l = 0;
		int r = 0;
		int k = 0;
		int ans = 0;
		System.out.print(" left  -> " );
		printArr(left);
		System.out.print(" right  -> " );
		printArr(right);
		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				arr[k] = left[l];
				l++;
				k++;
			} else {
				//System.out.println(" number " + left[l]);
				arr[k] = right[r];
				r++;
				k++;
				ans += (left.length - l);
				System.out.println(" number " + left[l] + " value " + (left.length - l));
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
		System.out.print(" sorted sub arr => ");
		printArr(arr);
		System.out.println(" count  => " + ans);
		System.out.println("-------------------------");
		return ans;
	}

}
