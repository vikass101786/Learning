package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BeautifulBracketTHing {

	public static void main(String[] args) {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String inp[] = sc.next().split("");
			String count = "";
			Stack<String> openBracket = new Stack<String>();
			Stack<String> closeBracket = new Stack<String>();
			for (int i = 0; i < inp.length; i++) {
				if (inp[i].equals("{")) {
					openBracket.add(inp[i]);
				} else if (inp[i].equals("}") && !openBracket.isEmpty()) {
					openBracket.pop();
				} else if (inp[i].equals("}") && openBracket.isEmpty()) {
					closeBracket.add("}");
				} else if (!inp[i].equals("}") || !inp[i].equals("{")) {
					flag = true;
					break;
				}
			}
			
			System.out.println((int)Math.ceil(openBracket.size()/2) + (int)Math.ceil(closeBracket.size()/2));

		}
	}
}
