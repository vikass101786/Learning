package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(10);
		ms.push(9);
		ms.getMin();
		ms.push(8);
		ms.getMin();
		ms.push(8);
		ms.getMin();
		ms.push(7);
		ms.getMin();
		ms.push(6);
		ms.getMin();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();

	}

	int top = -1;
	ArrayList<Integer> arrayList = new ArrayList<>();
	Stack<Integer> firstStack = new Stack<>();
	Stack<Integer> secondStack = new Stack<>();

	public void push(int x) {
		top++;
		arrayList.add(x);
		addElementInStack(x);
	}

	public void pop() {
		if (top != -1) {
			int element = arrayList.remove(top);
			top--;
			removeEleFromStack(element);
		}
	}

	public int top() {
		return top != -1 ? arrayList.get(top) : -1;
	}

	public void addElementInStack(int x) {

		while (!firstStack.isEmpty() && firstStack.peek() > x && firstStack.peek() != -1)
			secondStack.add(firstStack.pop());

		while (!secondStack.isEmpty())
			firstStack.add(secondStack.pop());

		firstStack.add(x);
	}

	public void removeEleFromStack(int element) {
		while (true && !firstStack.isEmpty()) {
			int value = firstStack.pop();
			if (value == element) {
				break;
			}
			secondStack.add(value);
		}

		while (!secondStack.isEmpty())
			firstStack.add(secondStack.pop());

	}

	public int getMin() {
		return firstStack.isEmpty() ? -1 : firstStack.peek();
	}

}
