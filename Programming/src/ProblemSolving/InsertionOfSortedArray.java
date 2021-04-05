package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionOfSortedArray {
	
	public static void main(String[] args) {
		System.out.println(new InsertionOfSortedArray().intersect(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 3, 4, 5, 6)),
				new ArrayList<Integer>(Arrays.asList(3,3,5))));
	}
	
	public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {

		int m = 0;
		int n = 0;
		ArrayList<Integer> list = new ArrayList<>();

		while (m < A.size() && n < B.size()) {
			if (A.get(m) < B.get(n)) {
				m++;
			} else if (A.get(m) > B.get(n)) {
				n++;
			} else {
				list.add(A.get(m));
			}
		}
		return list;
	}
}
