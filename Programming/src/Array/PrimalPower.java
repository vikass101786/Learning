package Array;

public class PrimalPower {

	public static void main(String[] args) {
		int arr[] = { 97, 43, 29, 11, 100, 47, 76, 83, 37, 19, 17, 19, 71, 0, 1, -82, 2, -83, 37, 13, 5, 97, 17, 30, 31,
				48, 2, 19, 31, 91, 19, 2, 5, 89, 2, 67, 31, 47, 43, 31, 5, 17, 83, 11, 47, 73, 19, 3, 3, 19, 59, 91, 67,
				7, 43, 4, 3, 51, 52, 23, 3, 37, 53, 89, 9, 41, 19, 61, 7, 5, 53, 59, 19, 11, 79, 37, 31, 37, 73, 82, 41,
				2, 13, 8, 2, 36, 19, 58, 17, 17, 59, 59, 37, 11, 13, 37, 47, 83, 31, 3 };
		new PrimalPower().solve(arr);
	}

	static Boolean arr[] = new Boolean[1000001];

	static {
		arr[1] = false;
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = true;
				for (int j = i * 2; j < arr.length; j += i) {
					if (arr[j] == null) {
						arr[j] = false;
					}
				}
			}
		}

	}

	public int solve(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && arr[A[i]] == true) {
				count++;
				System.out.println(A[i] + " " + i);
			}
		}
		return count;
	}

}
