package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {

	List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		System.out.println(new SequentialDigits().sequentialDigits(100, 300));
		System.out.println(new SequentialDigits().sequentialDigits(1000, 13000));
	}

	public List<Integer> sequentialDigits(int low, int high) {
		for (int i = 1; i <= 9; i++) {
			sequentialDigitsUtility(low, high, i);
		}
		Collections.sort(list);
		return list;
	}

	private void sequentialDigitsUtility(int low, int high, int answer) {
		if (answer >= low && answer <= high) {
				list.add(answer);
		}

		if (answer > high) {
			return;
		}

		int ld = answer % 10;

		if (ld >= 9) {
			return;
		}
		sequentialDigitsUtility(low, high, answer * 10 + (ld + 1));

	}

}
