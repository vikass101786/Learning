package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountRightTriangle {
	
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,2,3,3));
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2,1,1,1,2));
		System.out.println(new CountRightTriangle().solve(A, B));
	}

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();

		for (Integer x : A) {
			Integer count = xMap.putIfAbsent(x, 1);
			if (count != null) {
				xMap.put(x, count + 1);
			}
		}

		for (Integer x : B) {
			Integer count = yMap.putIfAbsent(x, 1);
			if (count != null) {
				yMap.put(x, count + 1);
			}
		}

		int ans = 0;

		for (int i = 0; i < A.size(); i++) {
			if (xMap.get(A.get(i)) >= 1 && yMap.get(B.get(i)) >= 1) {
				ans += ((xMap.get(A.get(i)) - 1) * (yMap.get(B.get(i)) - 1));
			}
		}
		return ans;
	}

}
