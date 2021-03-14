package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArray {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 2, 0, 6, 7, 5));
		arrange(list);

	}

	public static void arrange(ArrayList<Integer> a) {

		int max = 0;

		for (int i = 0; i < a.size(); i++) {
			if (max < a.get(i)) {
				max = a.get(i);
			}
		}

		max = max + 1;

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) < i) {

				int originalNum = a.get(a.get(i)) / max;

				a.set(i, (a.get(i) * max) + originalNum);

			} else {
				a.set(i, a.get(i) * max + a.get(a.get(i)));
			}
		}
		
		for (int i = 0; i < a.size(); i++) {
			a.set(i, a.get(i) % max);
		}
		
	}

}
