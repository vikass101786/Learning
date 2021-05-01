package Stack;

import java.util.Stack;

public class InFixToPostFix {
	
	public static void main(String[] args) {
		System.out.println(new InFixToPostFix().solve("a+b*(c^d-e)^(f+g*h)-i"));
	}

	public String solve(String A) {

		Stack<Character> stack = new Stack<>();
		stack.clear();
		StringBuffer ans = new StringBuffer();
		for (Character value : A.toCharArray()) {

			if (Character.isLetterOrDigit(value)) {
				ans.append(value);
			}

			else if (value == '(') {
				stack.add(value);
			}

			else if (value == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					ans.append(stack.pop());
				}
				if (!stack.isEmpty())
					stack.pop();
			}

			else {

				while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(value)) {
					ans.append(stack.pop());
				}
				stack.add(value);
			}
		}

		while (!stack.isEmpty())
			ans.append(stack.pop());

		return new String(ans);
	}

	public int precedence(Character operator) {

		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

}
