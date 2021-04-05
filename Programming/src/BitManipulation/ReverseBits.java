package BitManipulation;

public class ReverseBits {
	public static void main(String[] args) {
		System.out.println(new ReverseBits().reverse(2));
	}
	
	public long reverse(long a) {

		int num = 32;

		long revNum = 0;

		while (a > 0) {

			revNum <<= 1;

			if ((a & 1) == 1)

				revNum ^= 1;

			num--;

			a >>= 1;

		}

		return revNum << num;

	}
}
