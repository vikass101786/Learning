package Array;

public class OddAndEvenSequence {

	public static void main(String[] args) {
		int arr[] = { 12, 10, 28, 37, 43, 40, 14, 12, 48 };
		System.out.println(new OddAndEvenSequence().solve(arr));
	}

	public int solve(int[] A) {
		boolean flag = (A[0] & 1) == 0;
		int count = 1;
		flag = !flag;
		for (int i = 1; i < A.length; i++) {
			if (isEvenOrOdd(flag, A[i])) {
				count++;
				flag = !flag;
			}

		}
		return count;
	}

	public boolean isEvenOrOdd(boolean isEven, int num) {
		if (isEven) {
			return (num & 1) == 0;
		} else {
			return (num & 1) == 1;
		}
	}

}
