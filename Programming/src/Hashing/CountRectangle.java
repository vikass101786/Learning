package Hashing;

import java.util.ArrayList;
import java.util.Arrays;

public class CountRectangle {

	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 1, 2, 2));
		ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 1, 2));
		System.out.println(new CountRectangle().solve(arr1, arr2));
	}
	
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

		int ans = 0;

		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				if (!A.get(i).equals(A.get(j)) && !B.get(i).equals(B.get(j))) {
					int pair = 0;
					for (int k = 0; k < A.size(); k++) {
						if (k == j || k == i)
							continue;
						if ((A.get(i).equals(A.get(k)) || B.get(i).equals(B.get(k)))
								&& (A.get(j).equals(A.get(k)) || B.get(j).equals(B.get(k)))) {
							pair++;
						}
					}

					ans += (pair == 2) ? 1 : 0;
				}
			}
		}
		return ans / 2;
	}

}
