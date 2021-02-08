public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().addBinary("1010110111001101101000", "1000011011000000111100110"));
	}

	public String addBinary(String A, String B) {
		Integer ANum = A.length() - 1;
		Integer BNum = B.length() - 1;
		int carry = 0;
		String answer = "";
		char is_A_last_bit_set;
		char is_B_last_bit_set;
		while (ANum >= 0 && BNum >= 0) {
			is_A_last_bit_set = A.charAt(ANum);
			is_B_last_bit_set = B.charAt(BNum);
			if (is_A_last_bit_set == '1' && is_B_last_bit_set == '1' && carry == 0) {
				carry = 1;
				answer = 0 + answer;
			} else if (is_A_last_bit_set == '1' && is_B_last_bit_set == '1' && carry == 1) {
				carry = 1;
				answer = 1 + answer;
			} else if (is_A_last_bit_set == '0' && is_B_last_bit_set == '0' && carry == 0) {
				carry = 0;
				answer = 0 + answer;
			} else if (is_A_last_bit_set == '0' && is_B_last_bit_set == '0' && carry == 1) {
				carry = 0;
				answer = 1 + answer;
			} else if ((is_A_last_bit_set == '1' || is_B_last_bit_set == '1') && carry == 0) {
				carry = 0;
				answer = 1 + answer;
			} else if ((is_A_last_bit_set == '1' || is_B_last_bit_set == '1') && carry == 1) {
				carry = 1;
				answer = 0 + answer;
			}
			System.out.println(answer);
			ANum--;
			BNum--;
		}

		while (ANum >= 0) {
			is_A_last_bit_set = A.charAt(ANum);
			if (is_A_last_bit_set == '1' && carry == 0) {
				carry = 0;
				answer = 1 + answer;
			} else if (is_A_last_bit_set == '1' && carry == 1) {
				carry = 1;
				answer = 0 + answer;
			} else if (is_A_last_bit_set == '0' && carry == 0) {
				carry = 0;
				answer = 0 + answer;
			} else if (is_A_last_bit_set == '0' && carry == 1) {
				carry = 0;
				answer = 1 + answer;
			}
			System.out.println(answer);
			ANum--;
		}

		while (BNum >= 0) {
			is_B_last_bit_set = B.charAt(BNum);
			if (is_B_last_bit_set == '1' && carry == 0) {
				carry = 0;
				answer = 1 + answer;
			} else if (is_B_last_bit_set == '1' && carry == 1) {
				carry = 1;
				answer = 0 + answer;
			} else if (is_B_last_bit_set == '0' && carry == 0) {
				carry = 0;
				answer = 0 + answer;
			} else if (is_B_last_bit_set == '0' && carry == 1) {
				carry = 0;
				answer = 1 + answer;
			}
			System.out.println(answer);
			BNum--;
		}

		answer = (carry == 0) ? answer : (carry + answer);
		System.out.println(" final  " + answer);

		return answer;
	}
}
