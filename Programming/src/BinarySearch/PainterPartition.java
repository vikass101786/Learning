package BinarySearch;

import java.util.ArrayList;

public class PainterPartition {

	public static void main(String[] args) {
		int A = 1;
		int B = 10;
		// int arr[] = { 185, 186, 938, 558, 655, 461, 441, 234, 902, 681 };
		int arr[] = { 1 };
		System.out.println(new PainterPartition().paint(A, B, arr));
	}
	
	 private static final int MOD = 10000003;

	public int paint(int A, int B, int[] C) {

		int left = Integer.MAX_VALUE;
		int right = 0;
		long ans = Long.MAX_VALUE;
		int MODULAR = 10000003;
		Long duration = Long.valueOf(B);

		for (int i = 0; i < C.length; i++) {
			left = Math.min(left, C[i]);
			right += C[i];
		}

		while (left <= right) {
			int value = (right - left) / 2 + left;
			Pair p = isPainitingPossible(A, C, value);

			if (p.isPossible) {
				right = value - 1;
				ans = Math.min(p.maxValue, ans);
			} else {
				left = value + 1;
			}
		}
		return (int) (ans % MODULAR * duration % MODULAR) % MODULAR;
	}

	public Pair isPainitingPossible(int numOfPainter, int[] A, int maxCurdBoardSize) {
		System.err.println(" maxCurdBoardSize " + maxCurdBoardSize);
		int i = 0;
		int currentWorkDone = 0;
		int maxValue = Integer.MIN_VALUE;
		boolean isPossible = true;
		while (i < A.length && numOfPainter > 0) {

			if (A[i] > maxCurdBoardSize) {
				return new Pair(false, Integer.MAX_VALUE);
			}

			System.out.println(" current Index " + i + " current board size " + A[i]);
			System.out.println(" total work till now for painter " + numOfPainter + " >> " + currentWorkDone + A[i]);

			if (maxCurdBoardSize >= (currentWorkDone + A[i])) {
				currentWorkDone += A[i];
				i++;
			} else {
				maxValue = Math.max(maxValue, currentWorkDone);
				numOfPainter--;
				currentWorkDone = 0;
			}

		}

		if (i == A.length) {
			maxValue = Math.max(maxValue, currentWorkDone);
			numOfPainter--;
		}

		if (i < A.length || numOfPainter < 0) {
			isPossible = false;
		}

		System.out.println("===================");

		return new Pair(isPossible, maxValue);
	}

	public int paint1(int A, int B, ArrayList<Integer> C) {

		long res = Long.MAX_VALUE;
		long low = 0;
		long high = Long.MAX_VALUE;
		long mid;

		while (low <= high) {

			mid = low + ((high - low) >> 1);

			boolean status = possible(A, B, C, mid);

			if (status) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return (int) (res % MOD);

	}

	private boolean possible(int A, int B, ArrayList<Integer> C, long time) {

		int n = C.size();
		int index = 0;
		long total;

		for (int i = 0; i < A && index < n; i++) {

			total = 0;

			while (total < time && index < n) {
				total += (1L * C.get(index) * B);
				if (total > time)
					break;
				index++;
			}
		}

		if (index != n)
			return false;

		return true;
	}

	static class Pair {
		boolean isPossible;
		int maxValue;

		Pair(boolean isPossible, int maxValue) {
			this.isPossible = isPossible;
			this.maxValue = maxValue;
		}
	}

}
