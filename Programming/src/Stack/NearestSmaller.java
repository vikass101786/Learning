package Stack;

import java.util.Stack;

public class NearestSmaller {
	
	public static void main(String[] args) {
		int arr [] = {4, 5, 2, 10, 8};
		System.out.println(new NearestSmaller().prevSmaller(arr));
	}

    public int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans [] = new int [A.length];
        
        for (int i = 0 ; i < A.length ; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }
            ans [i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(A[i]);
        }
        return ans;
    }

}
