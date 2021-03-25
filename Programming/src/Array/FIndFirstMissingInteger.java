package Array;

public class FIndFirstMissingInteger {

	/**
	 * First Missing Integer Problem Description
	 * 
	 * Given an unsorted integer array A of size N. Find the first missing positive
	 * integer.
	 * 
	 * Note: Your algorithm should run in O(n) time and use constant space.
	 * 
	 * 
	 * 
	 * Problem Constraints 1 <= N <= 1000000
	 * 
	 * -10^9 <= A[i] <= 10^9
	 * 
	 * 
	 * 
	 * Input Format First argument is an integer array A.
	 * 
	 * 
	 * 
	 * Output Format Return an integer denoting the first missing positive integer.
	 * 
	 * 
	 * 
	 * Example Input Input 1:
	 * 
	 * [1, 2, 0] Input 2:
	 * 
	 * [3, 4, -1, 1] Input 3:
	 * 
	 * [-8, -7, -6]
	 * 
	 * 
	 * Example Output Output 1:
	 * 
	 * 3 Output 2:
	 * 
	 * 2 Output 3:
	 * 
	 * 1
	 * 
	 * 
	 * Example Explanation Explanation 1:
	 * 
	 * A = [1, 2, 0] First positive integer missing from the array is 3.
	 * 
	 */

	public static void main(String[] args) {
		int arr[] = { 880, 49, 56, 99, 69, 142, 895, 508, 286, 646, 473, 174, 79, 716, 125, 136, 964, 104, 859, 575,
				896, 868, 375, 106, 723, 93, 857, 10, 561, 325, 235, 701, 379, 536, 151, 789, 481, 836, 883, 573, 929,
				522, 693, 83, 196, 776, 26, 491, 264, 288, 96, 392, 847, 838, 459, 950, 501, 690, 393, 380, 193, 926,
				593, 801, 806, 832, 624, 187, 92, 935, 966, 984, 444, 923, 758, 100, 334, 548, 1, 956, 841, 754, 25,
				293, 643, 765, 947, 678, 32, 697, 849, 863, 795, 108, 704, 664, 493, 143, 914, -3, 722, 813, 750, 500,
				581, 513, 18, 488, 51, 71, 725, 418, 706, 230, 178, 205, 652, 251, 766, 432, 858, 662, 862, 875, 435,
				354, 599, 524, 437, 637, 589, 785, 595, 518, 922, 727, 76, 553, 796, 504, 13, 998, 983, 270, 78, 50,
				625, 67, 996, 158, 850, 137, 285, 605, 38, 856, 458, 118, 870, 672, 902, 341, 651, 959, 803, 419, 39,
				63, 656, 707, 566, 570, 218, 805, 708, 510, 860, 634, 327, 641, 517, 770, 29, 90, 610, 901, 981, 159,
				764, 621, 559, 946, 609, 694, 993, 928, 636, 742, 906, 40, 11, 702, 808, 120, 531, 478, 632, 775, 97,
				203, 890, 967, 798, 283, 312, 434, 626, 361, 282, 170, 48, 848, 739, 9, 436, 17, 640, 606, 440, 718,
				597, 853, 121, 336, 465, 568, 747, 275, 760, 756, 316, 535, 777, 982, 732, 724, 498, 696, 162, 229, 176,
				374, 166, 15, 888, 16, 911, 347, 558, 172, 247, 994, 503, 527, 344, 185, 529, 453, 711, 530, 131, 223,
				546, 741, 793, 89, 791, 699, 783, 183, 675, 113, 258, 426, 234, 287, 779, 261, 738, 213, 44, 618, 780,
				685, 717, 306, 70, 892, 534, 307, 807, 970, 489, 550, 190, 659, 2, 909, 499, 215, 289, 86, 260, 455,
				114, 918, 430, 871, 676, 975, 414, 497, 689, 212, 837, 359, 752, 954, 649, 576, 116, 257, 778, 290, 762,
				728, 244, 495, 772, 267, 898, 661, 454, 103, 519, 1000, 980, 844, 578, -4, 936, 81, 74, 639, 748, 572,
				35, 360, 666, 252, 308, 19, 968, 456, 8, 608, 348, 953, 787, 525, 601, 815, 388, 881, 823, 948, 123,
				189, 671, 366, 237, 64, 734, 679, 105, 278, 653, 300, 222, 413, 584, 305, 978, 12, 428, 424, 442, 583,
				502, 119, 208, 545, 33, 709, 409, 330, 372, 460, 385, 557, 161, 547, 817, 301, 291, 768, 467, 979, 246,
				94, 885, 705, 416, 799, 423, 112, 539, 134, 820, 204, 938, 490, 479, 540, 562 };
		System.out.println(firstMissingPositive(arr));
	}

	public static int firstMissingPositive(int[] A) {

		int max_possible_missing_num = A.length + 1;
		int index = 0;
		for (; index < A.length; index++) {
			if (A[index] == 1) {
				break;
			}
		}

		if (index >= A.length) {
			return 1;
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= 0 || A[i] > A.length + 1) {
				A[i] = 1;
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (Math.abs(A[i]) - 1 >= 0 && Math.abs(A[i]) - 1 < A.length && A[Math.abs(A[i]) - 1] > 0) {
				A[Math.abs(A[i]) - 1] = A[Math.abs(A[i]) - 1] * -1;
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				max_possible_missing_num = i + 1;
				break;
			}
		}
		return max_possible_missing_num;
	}
}

/*public int firstMissingPositive1(ArrayList<Integer> A) {
    
    int n = A.size();
    for (int i = 0; i < n; i++) {
        if (A.get(i) > 0 && A.get(i) <= n) {
            int pos = A.get(i) - 1;
            if (A.get(pos) != A.get(i)) {
                Collections.swap(A, pos, i);
                i--;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        if (A.get(i) != i + 1) return (i + 1);
    }
    return n + 1;

}*/

/**
 * Note: numbers A[i]<=0 and A[i]>N ( N being the size of the array ) is not
 * important to us since the missing positive integer will be in the range [1,
 * N+1].
 * 
 * The answer will be N+1 only if all of the elements of the array are exact one
 * occurrence of [1, N].
 * 
 * Creating buckets would have been an easy solution if using extra space was
 * allowed.
 * 
 * An array of size N initialized to 0 would have been created.
 * 
 * For every value A[i] which lies in the range [1, N], its count in the array
 * would have been incremented.
 * 
 * Finally, traversing the array would help to find the first array position
 * with value 0 and that will be our answer. However, usage of buckets is not
 * allowed, can we use the existing array as bucket somehow?
 * 
 * Now, since additional space is not allowed either, the given array itself
 * needs to be used to track it.
 * 
 * It may be helpful to use the fact that the size of the set we are looking to
 * track is [1, N]
 * 
 * which happens to be the same size as the size of the array.
 * 
 * This means we can use the array to track these elements.
 * 
 * We traverse the array and if A[i] is in [1,N] range, we try to put in the
 * index of same value in the array.
 */
