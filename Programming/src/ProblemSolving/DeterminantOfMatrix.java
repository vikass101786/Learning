package ProblemSolving;

public class DeterminantOfMatrix {

	public static void main(String[] args) {
		int A[][] = { { -87, 79, 32 },
					  { -93, -98, 21 }, 
					  { -87, 32, -28 } };
		System.out.println(solve(A));
	}

	public static int solve(final int[][] A) {
		int ans = 0;

		if (A.length == 2) {
			ans = (A[0][0] * A[1][1] - A[0][1] * A[1][0]);
		} else {
			ans = (A[0][0] * ((A[1][1] * A[2][2]) - (A[1][2] * A[2][1])))
					- (A[0][1] * ((A[1][0] * A[2][2]) - (A[1][2] * A[2][0])))
					+ A[0][2] * ((A[1][0] * A[2][1]) - (A[2][0] * A[1][1]));
		}

		// 0,0 0,1 0,2
		// 1,0 1,1 1,2
		// 2,0 2,1 2,2
		return ans;
	}
}
