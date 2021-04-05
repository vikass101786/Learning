package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class RemoveDupFromSortedArray {
	
	public static void main(String[] args) {
		System.out.println(1 | 2 | 3 | 3 | 4 | 5 | 6 | 3 | 3 | 5);
		System.out.println(new RemoveDupFromSortedArray().removeDuplicates(new ArrayList<Integer>(Arrays.asList(5000, 5000, 5000))));
	}

	public int removeDuplicates(ArrayList<Integer> a) {

		int count = 0;
		ListIterator<Integer> list = a.listIterator();
		Integer prev = -1;
		Integer current = -1;

		while (list.hasNext()) {
			current = list.next();
			if (!prev.equals(current)) {
				count++;
			} else {
				list.remove();
			}
			prev = current;
		}
		return count;
	}

}
