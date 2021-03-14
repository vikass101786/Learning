package ProblemSolving;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public static void main(String[] args) {
		int arr [] = {1, 0, 1, 0, 1};
		System.out.println(solve(arr));
	}
	public static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentPrefixSum = (A[0] == 0) ? -1 : 1;
        map.put(0, -1);
        map.put(currentPrefixSum,0);
        int max_diff = Integer.MIN_VALUE;
        for (int i = 1 ; i < A.length ; i++) {
            int num = (A[i] == 0) ? -1 : 1;
            A[i] = (currentPrefixSum + num);
            currentPrefixSum = A[i];
            if (!map.containsKey(currentPrefixSum)) {
                map.put(currentPrefixSum, i);
            } else {
                int currentDiff = i - map.get(currentPrefixSum);
                max_diff = Math.max(currentDiff, max_diff);
            }
        }
    return max_diff;
    }
}
