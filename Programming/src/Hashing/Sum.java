package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(-10, -10, -10);
		int B = -5;
		System.out.println(new Sum().twoSum(arr, B));
	}

	Map<Integer, ArrayList<Integer>> map = new HashMap<>();

	public ArrayList<Integer> twoSum(final List<Integer> A, int B) {

		List<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < A.size(); i++) {
			map.putIfAbsent(A.get(i), new ArrayList());
			map.get(A.get(i)).add(i + 1);
		}

		for (int i = 0; i < A.size(); i++) {
			int pair_1 = A.get(i);
			int index_2 = -1;
			if (map.containsKey(B - pair_1) && ((index_2 = checkForValidPair(i + 1, map.get(B - pair_1))) != -1)) {
				Pair p = new Pair(i + 1, index_2);
				list.add(p);
			}
		}
		Collections.sort(list);
		ArrayList<Integer> ansList = new ArrayList<>();

		if (list.size() > 0) {
			ansList.add(list.get(0).start);
			ansList.add(list.get(0).end);
		}
		return ansList;
	}

	public int checkForValidPair(int index, ArrayList<Integer> list) {
		Integer next_index = Integer.MAX_VALUE;
		for (Integer val : list) {
			if (index < val && val < next_index) {
				next_index = val;
			}
		}
		return (next_index == Integer.MAX_VALUE ? -1 : next_index);
	}

}

class Pair implements Comparable<Pair> {
	Integer start;
	Integer end;

	Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int compareTo(Pair p) {
		if (p.end == end) {
			return start.compareTo(p.start);
		} else {
			return end.compareTo(p.end);
		}
	}

	@Override
	public String toString() {
		return "Pair [start=" + start + ", end=" + end + "]";
	}

}
