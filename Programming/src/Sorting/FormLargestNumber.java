package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FormLargestNumber {

	public static void main(String[] args) {
		List<StringBuffer> list = Arrays.asList(new StringBuffer("3"), 
				new StringBuffer("30"),
				new StringBuffer("34"),
				new StringBuffer("5"), 
				new StringBuffer("9"));
		System.out.println(new FormLargestNumber().largestNumber(list));
	}

	public String largestNumber(final List<StringBuffer> A) {

		Collections.sort(A, new Comparator<StringBuffer>() {
			@Override
			public int compare(StringBuffer M, StringBuffer N) {
				StringBuffer MN = new StringBuffer(M).append(N);
				StringBuffer NM = new StringBuffer(N).append(M);
				// System.out.println(" MN " + MN + " NM " + NM + " value " + value);
				return MN.compareTo(NM) > 0 ? -1 : 1;
			}
		});

		String ans = "";

		Iterator it = A.iterator();
		while (it.hasNext())
			ans += it.next();

		return ans;
	}

}
