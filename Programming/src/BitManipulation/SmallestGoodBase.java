package BitManipulation;

public class SmallestGoodBase {

	/**
	 * Smallest Good Base Given an integer A, we call k >= 2 a good base of A, if
	 * all digits of A base k are 1. Now given a string representing A, you should
	 * return the smallest good base of A in string format.
	 * 
	 * 
	 * Input Format
	 * 
	 * The only argument given is the string representing A. Output Format
	 * 
	 * Return the smallest good base of A in string format. Constraints
	 * 
	 * 3 <= A <= 10^18 For Example
	 * 
	 * Input 1: A = "13" Output 1: "3" (13 in base 3 is 111)
	 * 
	 * Input 2: A = "4681" Output 2: "8" (4681 in base 8 is 11111).
	 * 
	 * ×
	 * 
	 */

	public static void main(String[] args) {
		System.out.println(new SmallestGoodBase().solve("13"));
	}

	String solve(String A) {
		Long num = Long.parseLong(A);
		Long ans = Long.MAX_VALUE;
		for (int i = 2; i <= 61; i++) {
			long b = isBasePossible(i, num, num - 1);
			ans = Math.min(ans, b);
		}
		return ans + "";
	}

	private long isBasePossible(int i, Long num, Long range) {

		Long left = 2l;
		Long right = range;
		Long value = Long.MAX_VALUE;
		while (left <= right) {
			Long base = (right - left) / 2 + left;
			Long baseAns = evaluatedNumber(i, base, num);
			if (num.longValue() == baseAns.longValue()) {
				value = base;
				break;
			} else if (num.longValue() > baseAns.longValue()) {
				left = base + 1;

			} else {
				right = base - 1;
			}
		}
		return value;
	}

	private Long evaluatedNumber(int num, Long base, Long A) {
		Long value = 0l;
		for (int i = 0; i < num; i++) {
			value = value * base + 1;
			if (value > A)
				break;
		}

		return value;
	}

	long play(long n, int d) {
		double t = n;
		long r = (long) (Math.pow(t, 1.0 / d) + 1);
		long l = 1;
		while (l <= r) {
			long m = l + (r - l) / 2;
			long sum = 1, cur = 1;
			for (int i = 1; i <= d; i++) {
				cur *= m;
				sum += cur;
			}
			if (sum == n)
				return m;
			if (sum > n)
				r = m - 1;
			else
				l = m + 1;
		}
		return 0;
	}

	public String solve1(String A) {
		long n = Long.parseLong(A);
		long x = 1;
		for (int i = 62; i >= 1; i--) {
			if ((x << i) < n) {
				long cur = play(n, i);
				if (cur != 0) {
					return (cur + "");
				}
			}
		}
		return (n - 1 + "");
	}

}
