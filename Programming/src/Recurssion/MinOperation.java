package Recurssion;

public class MinOperation {
	
	public static void main(String[] args) {
		String input = "bbabbbaaaaaaaab";
		System.out.println(new MinOperation().minOperation(input, 0, input.length()-1));
	}

	public Integer minOperation(String input, int currenStarttIndex, int currentEndIndex) {

		if (input.length() == 0 || input.length() == currenStarttIndex || isValidString(input)) {
			return 0;
		}

		Integer q1 = Integer.MAX_VALUE, q2 = Integer.MAX_VALUE , q3 = Integer.MAX_VALUE, q4 = Integer.MAX_VALUE;
		int i = currenStarttIndex;
		for (; i < input.length(); i++) {
			if (input.charAt(i) == 'a') {
				input = input.substring(0, i) + input.substring(i + 1);
				break;
			}
		}
		
		q1 = minOperation(input, i, currentEndIndex) + 1;
		
		int j = currenStarttIndex;
		for (; j < input.length(); j++) {
			if (input.charAt(j) == 'b') {
				input = input.substring(0, j) + input.substring(j + 1);
				break;
			}
		}
		
		q2 = minOperation(input, j, currentEndIndex) + 1;

		q3 = minOperation(input.substring(currenStarttIndex), currenStarttIndex + 1, currentEndIndex) + 1;

		q4 = minOperation(input.substring(0, input.length()), currenStarttIndex, input.length()-1) + 1;

		return Math.min(q1, Math.min(q2, Math.min(q3, q4)));
	}

	private static boolean isValidString(String input) {

		boolean ans = false;
		int i = 0;
		for (; i < input.length(); i++) {
			if (input.charAt(i) == 'a') {
				break;
			}
		}

		if (i == input.length()) {
			ans = true;
		}

		int j = 0;
		if (!ans) {

			for (; j < input.length(); j++) {
				if (input.charAt(j) == 'b') {
					break;
				}
			}

			if (j == input.length()) {
				ans = true;
			}

		}

		if (!ans) {
			int k = j;
			for (; k < input.length(); k++) {

				if (input.charAt(k) == 'a') {
					break;
				}
			}

			if (k == input.length()) {
				ans = true;
			}

		}

		return ans;
	}

}
