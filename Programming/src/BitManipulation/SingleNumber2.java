package BitManipulation;

public class SingleNumber2 {
	
	public static void main(String[] args) {
		int arr [] = {1, 2, 3, 1, 2, 4};
		System.out.println(new SingleNumber2().solve(arr));
	}
	
	public int[] solve(int[] A) {

		int xorOfEle = A[0];

		for (int i = 1; i < A.length; i++) {
			xorOfEle ^= A[i];
		}

		int FirstSetBitPositionFromLast = 0;

		while (xorOfEle != 0) {
			if ((xorOfEle & 1) == 1) {
				break;
			}
			FirstSetBitPositionFromLast++;
			xorOfEle >>= 1;
		}

		int numToCheckSetBit = 1 << FirstSetBitPositionFromLast;

		int arr[] = new int[2];
		int xor1 = 0;
		int xor2 = 0;
		
		for (int i = 0; i < A.length; i++) {

			if ((A[i] & numToCheckSetBit) > 0) {
				xor1 ^= A[i];
			} else {
				xor2 ^= A[i];
			}

		}
		
		if (xor1 < xor2) {
			arr[0] = xor1;
			arr[1] = xor2;
		} else {
			arr[0] = xor2;
			arr[1] = xor1;
		}

		return arr;
	}
}
