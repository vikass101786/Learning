package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		Stack<Integer> st = new Stack<Integer>();
		int ans = 0;
		char previousElement = '\0';
		for (int i = 0; i < input.length(); i++) {

			char currentElement = input.charAt(i);
			if (currentElement != '(' && currentElement != ')') {

				if (Character.isDigit(currentElement)) {
					st.push(currentElement - '0');
				} else {
					if (previousElement != '\0') {
						if (st.isEmpty()) {
							ans += value(previousElement);
						} else {
							int mul = evaluateStack(st);
							ans += value(previousElement) * mul;
						}
					}
					previousElement = currentElement;
				}
			}
		}
		if (st.isEmpty()) {
			ans += value(previousElement);
		} else {
			int mul = evaluateStack(st);
			ans += value(previousElement) * mul;
		}
		System.out.println(ans);
	}

	public static int evaluateStack(Stack<Integer> st) {
		int output = 0;
		int mul = 1;
		while (!st.isEmpty()) {
			output += (st.pop() * mul);
			mul *= 10;
		}
		return output;
	}

	public static int value(Character c) {
		switch (c) {
		case 'C':
			return 12;
		case 'H':
			return 1;
		case 'O':
			return 16;
		}
		return 0;
	}
}