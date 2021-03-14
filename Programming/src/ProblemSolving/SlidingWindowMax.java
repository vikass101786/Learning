package ProblemSolving;

public class SlidingWindowMax {

	public static void main(String[] args) {
		System.out.println(Integer.toString(10) +" " + String.valueOf(10));
		int arr[] = { 90, 943, 777, 658, 742, 559, 623, 263, 880, 176, 354, 434, 699, 501, 551, 821, 563, 974, 701, 479,
				238, 87, 61, 910, 204, 534, 369, 845, 566, 19, 939, 87, 708, 323, 662, 32, 655, 835, 67, 360, 550, 173,
				488, 420, 680, 805, 630, 48, 791, 991, 791, 819, 772, 228, 123, 303, 642, 780, 115, 89, 919, 830, 271,
				853, 588, 249, 20, 940, 851, 749, 340, 587, 235, 106, 125, 32, 319, 590, 354, 751, 761, 564, 484, 51,
				202, 370, 216, 130, 146, 632 };
		int b = 6;
	//	System.out.println(slidingMaximum(arr, b));
	}

	public static int[] slidingMaximum(final int[] A, int B) {

		int outputArr[] = new int[A.length - B + 1];
		int index = 0;
		int maxEleInCurrentWindow = A[0];
		int currentIndexOfMaxEle = 0;
		int i = 1;
		for (; i < B; i++) {
			if (maxEleInCurrentWindow < A[i]) {
				maxEleInCurrentWindow = A[i];
				currentIndexOfMaxEle = i;
			}
		}

		outputArr[index] = maxEleInCurrentWindow;
		index++;

		for (; i < A.length; i++) {
			int k = index;
			if ((index > currentIndexOfMaxEle) && (A[k] < maxEleInCurrentWindow)) {
				int iter_value = B;
				maxEleInCurrentWindow = 0;
				while (k < A.length && iter_value >= 0) {
					if (A[k] > maxEleInCurrentWindow) {
						maxEleInCurrentWindow = A[k];
						currentIndexOfMaxEle = k;
					}
					k++;
					iter_value--;
				}
			} else if ((index > currentIndexOfMaxEle) && (A[i] > maxEleInCurrentWindow)) {
				maxEleInCurrentWindow = A[i];
				currentIndexOfMaxEle = i;
			} else if (A[i] > maxEleInCurrentWindow) {
				maxEleInCurrentWindow = A[i];
				currentIndexOfMaxEle = i;
			}
			outputArr[index] = maxEleInCurrentWindow;
			index++;
		}
		return outputArr;
	}
}
