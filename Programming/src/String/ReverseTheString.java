package String;

import java.util.ArrayList;
import java.util.List;

public class ReverseTheString {

	public static void main(String[] args) {
		System.out.println(
				solve("       fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq"));
	}

	public static String solve(String A) {

		StringBuffer ans = new StringBuffer("");

		String[] arr = A.split(" ");

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < arr.length; i++) {
			String inp = "";
			while (arr[i].equals("")) {
				inp += " ";
				i++;
			}
			if (!arr[i].equals("")) {
				inp += arr[i];
			}
			list.add(inp);
		}

		int i = list.size() - 1;
		for (; i > 0; i--) {
			ans.append(list.get(i) + " ");
		}
		ans.append(list.get(0));

		return new String(ans);
	}
}
