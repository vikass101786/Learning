package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class InterestingArray {

	/**
	 * Interesting Array Problem Description
	 * 
	 * You have an array A with N elements. We have 2 types of operation available
	 * on this array : We can split a element B into 2 elements C and D such that B
	 * = C + D. We can merge 2 elements P and Q as one element R such that R = P^Q
	 * i.e XOR of P and Q. You have to determine whether it is possible to make
	 * array A containing only 1 element i.e. 0 after several splits and/or merge?
	 * 
	 * 
	 * 
	 * Problem Constraints 1 <= N <= 100000
	 * 
	 * 1 <= A[i] <= 106
	 * 
	 * 
	 * 
	 * Input Format The first argument is an integer array A of size N.
	 * 
	 * 
	 * 
	 * Output Format Return "Yes" if it is possible otherwise return "No".
	 * 
	 * 
	 * 
	 * Example Input Input 1:
	 * 
	 * A = [9, 17] Input 2:
	 * 
	 * A = [1]
	 * 
	 * 
	 * Example Output Output 1:
	 * 
	 * Yes Output 2:
	 * 
	 * No
	 * 
	 * 
	 * Example Explanation Explanation 1:
	 * 
	 * Following is one possible sequence of operations - 1) Merge i.e 9 XOR 17 = 24
	 * 2) Split 24 into two parts each of size 12 3) Merge i.e 12 XOR 12 = 0 As
	 * there is only 1 element i.e 0. So it is possible. Explanation 2:
	 * 
	 * There is no possible way to make it 0.
	 * 
	 */

	public static void main(String[] args) {
		int arr[] = { 5030, 7120, 5995, 237, 7582, 8476, 2174, 8787, 7611, 6616, 4640, 8907, 2164, 2753, 8246, 3858,
				8795, 2762, 3378, 1527, 4725, 8119, 4447, 4834, 8465, 3253, 5664, 4404, 3114, 8380, 7844, 7975, 8413,
				8338, 1682, 6535, 5500, 5400, 4160, 1849, 9472, 3114, 8330, 1255, 753, 4995, 4090, 7392, 4297, 65, 384,
				2354, 847, 3906, 4016, 4424, 3316, 709, 6140, 5437, 2440, 2189, 130, 5699, 9506, 1243, 2862, 1141, 6659,
				964, 7918, 5976, 5490, 9903, 9106, 2042, 2676, 3231, 3580, 299, 9134, 8663, 5389, 3268, 6394, 3092,
				5235, 5109, 6224, 3314, 4611, 5381, 6032, 230, 5363, 3807, 3176, 4085, 966, 2880, 2591, 9157, 2971,
				8330, 692, 5620, 7286, 665, 7865, 6799, 1393, 4977, 3075, 2960, 5979, 9158, 7903, 4771, 8390, 5238,
				9661, 9410, 4020, 9300, 2499, 6477, 6404, 8553, 6809, 2659, 1930, 2559, 763, 2818, 9021, 5318, 9321,
				286, 4721, 8026, 8236, 7179, 5207, 6036, 5518, 3781, 4672, 4357, 1274, 2218, 2158, 3079, 6340, 8790,
				7674, 4099, 9847, 424, 3323, 7658, 2716, 2036, 6562, 1319, 5228, 433, 1287, 6290, 5199, 2479, 770, 5397,
				6168, 1824, 1119, 7176, 8299, 3045, 6480, 7447, 764, 3381, 1095, 1318, 8162, 4862, 6442, 3061, 6213,
				9495, 9439, 5961, 7153, 2888, 7218, 4371, 7009, 6645, 3701, 8882, 666, 9485, 8833, 3391, 4508, 1982,
				4984, 6911, 711, 1902, 9143, 7240, 5051, 1199, 7843, 3519, 9739, 7046, 4694, 4537, 1014, 5507, 6184,
				3731, 9066, 2129, 3345, 145, 5094, 4371, 7354, 6262, 9790, 8190 };
		System.out.println(new InterestingArray().solve(arr));

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(5030, 7120, 5995, 237, 7582, 8476, 2174, 8787,
				7611, 6616, 4640, 8907, 2164, 2753, 8246, 3858, 8795, 2762, 3378, 1527, 4725, 8119, 4447, 4834, 8465,
				3253, 5664, 4404, 3114, 8380, 7844, 7975, 8413, 8338, 1682, 6535, 5500, 5400, 4160, 1849, 9472, 3114,
				8330, 1255, 753, 4995, 4090, 7392, 4297, 65, 384, 2354, 847, 3906, 4016, 4424, 3316, 709, 6140, 5437,
				2440, 2189, 130, 5699, 9506, 1243, 2862, 1141, 6659, 964, 7918, 5976, 5490, 9903, 9106, 2042, 2676,
				3231, 3580, 299, 9134, 8663, 5389, 3268, 6394, 3092, 5235, 5109, 6224, 3314, 4611, 5381, 6032, 230,
				5363, 3807, 3176, 4085, 966, 2880, 2591, 9157, 2971, 8330, 692, 5620, 7286, 665, 7865, 6799, 1393, 4977,
				3075, 2960, 5979, 9158, 7903, 4771, 8390, 5238, 9661, 9410, 4020, 9300, 2499, 6477, 6404, 8553, 6809,
				2659, 1930, 2559, 763, 2818, 9021, 5318, 9321, 286, 4721, 8026, 8236, 7179, 5207, 6036, 5518, 3781,
				4672, 4357, 1274, 2218, 2158, 3079, 6340, 8790, 7674, 4099, 9847, 424, 3323, 7658, 2716, 2036, 6562,
				1319, 5228, 433, 1287, 6290, 5199, 2479, 770, 5397, 6168, 1824, 1119, 7176, 8299, 3045, 6480, 7447, 764,
				3381, 1095, 1318, 8162, 4862, 6442, 3061, 6213, 9495, 9439, 5961, 7153, 2888, 7218, 4371, 7009, 6645,
				3701, 8882, 666, 9485, 8833, 3391, 4508, 1982, 4984, 6911, 711, 1902, 9143, 7240, 5051, 1199, 7843,
				3519, 9739, 7046, 4694, 4537, 1014, 5507, 6184, 3731, 9066, 2129, 3345, 145, 5094, 4371, 7354, 6262,
				9790, 8190));
		System.out.println(new InterestingArray().solve(list));
	}

	/*
	 * if sum of array elements is even then its possible
	 * otherwise not. Because even number can be divided 
	 * into two equal pairs i.e 12 can be divided into
	 * 6 + 6 and 6^6 = 0
	 * **/
	
	public String solve(int[] A) {

		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		return ((sum & 1) == 1) ? "No" : "Yes";
	}

	public String solve(ArrayList<Integer> A) {

		int cnt = 0;
		for (int x : A) {
			if (x % 2 == 1)
				cnt++;
		}

		if (cnt % 2 == 1)
			return "No";
		else
			return "Yes";
	}

	/**
	 * If any element in array is even then it can be made 0. Split that element in
	 * two equal parts of A[i]/2 and A[i]/2. XOR of two equal numbers is zero.
	 * Therefore this strategy makes an element 0.
	 * 
	 * If any element is odd. Split it in two part: 1, A[i]-1. Since A[i]-1 is even,
	 * it can be made 0 by above strategy. Therefore an odd element can reduce its
	 * size to 1.
	 * 
	 * Two odd elements can therefore be made 0 by following above strategy and
	 * finally XOR them (i.e. 1) as 1 XOR 1 = 0.
	 * 
	 * Therefore if number of odd elements in array is even, then answer is
	 * possible. Otherwise an element of value 1 will be left and it is not possible
	 * to satisfy the condition.
	 */

}
