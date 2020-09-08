package Stack;

import java.util.Scanner;
import java.util.Stack;

public class CompileCode {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int query = sc.nextInt();
		while(query-- > 0) {
			int length = sc.nextInt();
			Stack<String> st = new Stack<String>();
			int count = 0;
			int ans = 0;
			String inp [] = sc.next().split("");
			for (int i = 0 ; i < length ; i++) {
				if(inp[i].equals("<")) {
					st.add(inp[i]);
				}else if(inp[i].equals(">") && !st.isEmpty()) {
					st.pop();
					count += 2;
				}else if(inp[i].equals(">") && st.isEmpty()) {
					break;
				}
				
				if(st.isEmpty()) {
					ans = count;
				}
			}
			System.out.println(ans);
		}
	}
	
}
