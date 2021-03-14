package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagram {
	
	public static void main(String[] args) {
		
		//System.out.println(new Anagram().anagrams(Arrays.asList("cde", "bee")));
		System.out.println(isAnagram("zzz".toCharArray(), "zzz".toCharArray()));
	}
	
	
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

		ArrayList<ArrayList<Integer>> ansList = new ArrayList<ArrayList<Integer>>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.size(); i++) {
			ArrayList<Integer> angList = new ArrayList<Integer>();
			if (!set.contains(i)) {
				String ang_1 = A.get(i);
				angList.add(i + 1);
				for (int k = i + 1; k < A.size(); k++) {
					String ang_2 = A.get(k);
					boolean isAnagram = isAnagram(ang_1, ang_2);
					if (isAnagram) {
						angList.add(k + 1);
						set.add(k);
					}
				}
			}
			if (angList.size() > 0) {
				ansList.add(angList);
			}
		}
		return ansList;
	}

	public static boolean isAnagram(String ang_1, String ang_2) {

		int num = 0;

		if (ang_1.length() != ang_2.length())
			return false;

		for (int i = 0; i < ang_1.length(); i++) {
			System.out.println((int)ang_1.charAt(i) + " : " + ang_1.charAt(i));
			num += ang_1.charAt(i);
		}

		for (int i = 0; i < ang_2.length(); i++) {
			System.out.println((int)ang_2.charAt(i) + " : " + ang_2.charAt(i));
			num -= ang_2.charAt(i);
		}

		return num == 0;
	}

	
	
	public static boolean isAnagram(char [] ang_1 , char [] ang_2) {
		int count [] = new int [27];
		if (ang_1.length != ang_2.length)
			return false;
		
		for (int i = 0 ; i < ang_1.length ; i++) {
			count[(int)ang_1[i] - 96]++;
			count[(int)ang_2[i] - 96]--;
		}
		
		
		for (int i = 0 ; i < count.length ; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
