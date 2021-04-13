package BinarySearch;

public class AthMagicalNumber {
	
	public static void main(String[] args) {
		System.out.println(new AthMagicalNumber().solve(807414236, 3788, 38141));
	}

	public int solve(int A, int B, int C) {
		long left = 1l;
		long right = (long) Math.pow(10, 18);
		Long ans = Long.MAX_VALUE;
		while (left <= right) {
			long value = (right - left) / 2 + left;

			if (isValid(A, B, C, value)) {
				ans = Math.min(value, ans);
				right = value - 1;
			} else {
				left = value + 1;
			}
		}
		return (int)(ans%1000_000_007);
	}

	private boolean isValid(int A, int B, int C, long value) {
		long X = (value / (1l * B));
		long Y = (value / (1l * C));
		long Z = (value / findLCM(B, C));
		if (A <= (X + Y - Z)) {
			return true;
		}
		return false;
	}

	public long findLCM(int B, int C) {
		return (B * C) / findGCD(B, C);
	}

	// LCM(a, b) = (a x b) / GCD(a, b)

	public int findGCD(int B, int C) {
		if (B == 0)
			return C;
		return findGCD(C % B, B);
	}

}
