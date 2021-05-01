package Sorting;

public class InversionCountInArray {
	
	public static void main(String[] args) {
		int arr [] = {3,2,1};
		System.out.println(new InversionCountInArray().mergeSort(arr, 0, arr.length));
	}
	
	public int mergeSort(int[] A, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int mid = (start + end) / 2;

		int left[] = new int[mid];
		int right[] = new int[A.length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = A[i];
		}

		int k = 0;
		for (int i = mid; i < A.length; i++) {
			right[k] = A[i];
			k++;
		}

		int count = 0;

		count += mergeSort(left, start, mid);
		count += mergeSort(right, 0, A.length - mid);
		count += merge(left, right, A);

		return count;
	}

	public int merge(int[] leftArr, int[] rightArr, int[] A) {
		int swaps = 0;

		int left = 0;
		int right = 0;
		int k = 0;

		while (left < leftArr.length && right < rightArr.length) {

			if (leftArr[left] < rightArr[right]) {
				A[k] = leftArr[left];
				left++;
				k++;
			} else {
				A[k] = rightArr[right];
				right++;
				k++;
				swaps += (leftArr.length - left);
			}

		}

		while (left < leftArr.length) {
			A[k] = leftArr[left];
			left++;
			k++;
		}

		while (right < rightArr.length) {
			A[k] = rightArr[right];
			right++;
			k++;
		}

		return swaps;
	}
}
