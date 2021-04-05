package BitManipulation;

public class DivideIntegers {

	public static void main(String[] args) {
		System.out.println(new DivideIntegers().divide(-2147483648, -1));

	}

	public int divide(int A, int B) {
		boolean isNegative = false;
		if ((A > 0 && B < 0) || (A < 0 && B > 0))
			isNegative = true;
		Long q = 0l;

		Long a = (long) A;

		Long b = (long) B;

		a = Long.valueOf(Math.abs(a));

		b = Long.valueOf(Math.abs(b));

		Long value = 0l;
		for (Long bit = 31l; bit >= 0; bit--) {
			if ((value + (b << bit)) <= a) {
				value += (b << bit);
				q |= (1l << bit);
			}
		}

		if (isNegative) {
			q *= -1;
		}

		return (q >= Integer.MAX_VALUE || q < Integer.MIN_VALUE) ? Integer.MAX_VALUE : q.intValue();
	}

}
