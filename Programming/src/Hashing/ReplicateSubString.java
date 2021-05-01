package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ReplicateSubString {

	public static void main(String[] args) {
		System.out.println(new ReplicateSubString().solve(5, "acde"));
	}

	public int solve(int A, String B) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < B.length(); i++) {
			Character value = B.charAt(i);
			Integer count = map.putIfAbsent(value, 1);
			if (count != null) {
				map.put(value, count + 1);
			}
		}

		for (Map.Entry<Character, Integer> mapIter : map.entrySet()) {
			if ((mapIter.getValue() % A) != 0) {
				return -1;
			}
		}
		return 1;
	}

	/*public int solve1(int A, String B) {

		// hash array to keep a track of frequency of each character
		int hash[] = new int[26];

		for (int i = 0; i < B.length(); i++) {
			hash[B.charAt(i) - 'a']++;
		}

		int flag = 0;
		for (int i = 0; i < 26; i++) {
			// if the frequency of a charatcer present in the string isnt divisble by k, set
			// a flag which indicates that
			// it will never be possible to represent S as concatenation of K strings
			if (hash[i] % A != 0)
				flag = 1;
		}

		if (flag == 1)
			return -1;
		else
			return 1;

	}*/

}
