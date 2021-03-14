package String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	public static void main(String[] args) {
		char arr [] = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
		System.out.println(solve(arr));
	}
	
	public static int solve(char[] A) {
        String regexStr = "[a-zA-z]+";
        Pattern pattern = Pattern.compile(regexStr);
        String inputString = new String(A);
        Matcher matcher = pattern.matcher(inputString);
        if(!matcher.matches()) {
        	return 0;
        }
        return 1;
    }

}
