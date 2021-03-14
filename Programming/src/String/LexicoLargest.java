package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicoLargest {
	public static void main(String[] args) {
		System.out.println(getLargest("ittmcsvmoa_jktvvblefw"));;
	}

	public static String getLargest(String A) {
		int index = A.indexOf("_");
		String sub_string = A.substring(index + 1);
		String main_string = A.substring(0, index);
		char array_main[] = main_string.toCharArray();
		// System.out.println(main_string);
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < sub_string.length(); i++) {
			list.add(sub_string.charAt(i));
		}
		Collections.sort(list, Collections.reverseOrder());
		int k = 0;
		for (int i = 0; i < main_string.length() && k < list.size(); i++) {
			if (Character.valueOf(list.get(k)).compareTo(Character.valueOf(array_main[i])) > 0) {
				array_main[i] = list.get(k);
				k++;
			}
		}
		return new String(array_main);
	}
}
