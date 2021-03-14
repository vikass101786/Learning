package PrefixArray;

public class BeggarWorship {

	public static void main(String[] args) {
			int arr [][] = {{1, 2, 10},{2, 3, 20},{2, 5, 25}};
			int N = 5;
			System.out.println(new BeggarWorship().solve(N, arr));
	}

	public int[] solve(int A, int[][] B) {

		int arr[] = new int[A];
		for (int i = 0; i < B.length; i++) {
			arr[B[i][0] - 1] += B[i][2];
			System.out.println(B[i][0] - 1 + " " + arr[B[i][0] - 1]);
			if (B[i][1] <= A) {
				arr[B[i][1] - 1] += (-1 * B[i][2]);
			}
		}

		int currentSum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] += currentSum;
			currentSum = arr[i];
		}
		return arr;
	}
}
