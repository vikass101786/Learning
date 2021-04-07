package BinarySearch;

public class SquareRootOfInteger {
	
	public static void main(String[] args) {
		System.out.println(new SquareRootOfInteger().sqrt(930675566));
	}

	public int sqrt(int A) {

		if (A == 1)
			return 1;

		long left = 1;
		long right = A / 2;
		long ans = 0;

		while (left <= right) {

			long num = (right - left) / 2 + left;

			if (A == num * num) {
				ans = num;
				break;
			} else if (A < num * num) {
				right = num - 1;
			} else {
				ans = num;
				left = num + 1;
			}

		}
		return (int)ans;
	}

}
