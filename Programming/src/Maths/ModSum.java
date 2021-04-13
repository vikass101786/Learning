package Maths;

public class ModSum {

	public static void main(String[] args) {
		int arr[] = { 794, 924, 452, 548, 78, 475, 836, 924, 426, 421, 548, 115, 480, 926, 519, 45, 464, 116, 356, 111,
				79, 732, 309, 817, 880, 12, 119, 207, 433, 1, 947, 202, 95, 90, 468, 620, 996, 692, 178, 700, 311, 848,
				742, 782, 933, 586, 7, 671, 872, 235, 92, 383, 637, 952, 507, 360, 705, 684, 618, 303, 334, 876, 500,
				104, 491, 866, 966, 863, 498, 581, 554, 244, 223, 679, 892, 166, 877, 246, 699, 595, 794, 567, 282, 6,
				862, 528, 936, 19, 64, 796, 212, 24, 714, 725, 749, 620, 862, 37, 90, 876 };
		System.out.println(new ModSum().solve(arr));
	}

	public int solve(int[] A) {
		int MODULE = 1000_000_007;

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			max = Math.max(A[i], max);
		}

		int countArr[] = new int[max + 1];

		for (int i = 0; i < A.length; i++) {
			countArr[A[i]] += 1;
		}

		int num = 0;

		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] == 0)
				continue;
			for (int j = 0; j < countArr.length; j++) {
				if (countArr[j] == 0)
					continue;
				num += (i % j) % MODULE;
			}
		}
		return num;
	}

}
