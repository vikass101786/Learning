package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStackUsingStack {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
		System.out.println(new SortStackUsingStack().solve(arr));
	}

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		Stack<Integer> stackA = new Stack<>();
		Stack<Integer> stackB = new Stack<>();

		for (Integer number : A)
			stackA.add(number);

		while (!stackA.isEmpty()) {

			Integer value = stackA.pop();

			arrageElementInStack(stackA, stackB, value);
		}

		ArrayList<Integer> ans = new ArrayList<>();

		while (!stackB.isEmpty()) {
			ans.add(stackB.pop());
		}

		return ans;
	}

	public void arrageElementInStack(Stack<Integer> A, Stack<Integer> B, int value) {

		int count = 0;
		while (!B.isEmpty() && B.peek() < value) {
			A.add(B.pop());
			count++;
		}

		B.add(value);

		while (count > 0 && !A.isEmpty()) {
			B.add(A.pop());
			count--;
		}
	}

}
