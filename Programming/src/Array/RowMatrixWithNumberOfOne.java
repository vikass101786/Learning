package Array;

public class RowMatrixWithNumberOfOne {

	public static void main(String[] args) {

		int A[][] = { { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
					  { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
					  { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, 
					  { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 }, 
					{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 }, 
					{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
					{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, 
					{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 }, 
					{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 } };
				System.out.println(new RowMatrixWithNumberOfOne().solve(A));
	}

	public int solve(int[][] A) {

		int len = A.length;
		int K = A[0].length - 1;
		int count = 0;
		int ans = 0;
		for (int i = 0; i < len && K >= 0; i++) {
			int currentCount = 0;
			while (K >= 0 && A[i][K] == 1) {
				K--;
				currentCount++;
			}

			if (currentCount > 0) {
				count = (count + currentCount);
				ans = i;
			}
		}
		return ans;
	}

}
