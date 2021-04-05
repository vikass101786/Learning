package Sorting;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = { 180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5,
				6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51,
				52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101,
				102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130,
				135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171,
				172, 173, 174, 175, 176, 177 };
		System.out.println(new SearchInRotatedSortedArray().search(arr, 42));
	}

	public int search(final int[] A, int B) {
		return binarySearch(A, B, 0, A.length - 1);
	}

	public int binarySearch(final int[] A, int B, int start, int end) {

		if (start > end) {
			return -1;
		}

		int mid = (end - start) / 2 + start;

		if (A[mid] == B) {
			return mid;
		}

		if (A[mid] >= A[start]) {
			if (B <= A[mid] && B >= A[start])
				return binarySearch(A, B, start, mid - 1);
			else
			return binarySearch(A, B, mid + 1, end);
		}

		if (A[end] >= B && A[mid] <= B)
			return binarySearch(A, B, mid + 1, end);
		else
		return binarySearch(A, B, start, mid - 1);

	}
}