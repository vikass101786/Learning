import java.util.Scanner;

public class findSubSet {
	public static void main(String args[]) {
		// Your Code Here
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		printComb(input, "");
	}

	public static void printComb(String input, String answer) {

		if (input.length() == 0) {
			System.out.print(answer + ", ");
			return;
		}

		for (int i = 1; i <= input.length(); i++) {
			int intValue = Integer.valueOf(input.substring(0, i));
			if (i <= input.length() && intValue <= 26) {
				String remaining = input.substring(i);
				String currentAnswer = answer + "" + (char) (intValue + 96);
				printComb(remaining, currentAnswer);
			}
		}
	}

}
