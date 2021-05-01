package Stack;

import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		String[] arr = { "2", "1", "+", "3", "*" };
		System.out.println(new EvaluateExpression().evalRPN(arr));
	}

	public int evalRPN(String[] A) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < A.length; i++) {
			if ((A[i].equals("+") || A[i].equals("-") || A[i].equals("/") || A[i].equals("*"))) {
				int op1 = -1;
				int op2 = -1;

				if (!stack.isEmpty())
					op1 = stack.pop();

				if (!stack.isEmpty())
					op2 = stack.pop();

				performOperation(op1, op2, A[i], stack);
				continue;
			} 
				stack.add(Integer.valueOf(A[i]));
		}

		return stack.pop();
	}

	public void performOperation(int op1, int op2, String operator, Stack<Integer> stack) {
		int value = 0;
		switch (operator) {
		case "+":
			value = op2 + op1;
			break;

		case "-":
			value = op2 - op1;
			break;

		case "*":
			value = op2 * op1;
			break;

		case "/":
			value = op2 / op1;
			break;

		default:
			break;
		}

		stack.add(value);

	}

}
