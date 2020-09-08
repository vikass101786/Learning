package Recurssion;

import java.util.Scanner;

public class MappedStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        mappedStrings(inp, "");
	}

	private static void mappedStrings(String inp, String out) {
		if (inp.length() == 0) {
          System.out.println(out);
        return;
    }

    int singleDigitNumber = inp.charAt(0) - '0';
    char ch = (char) (singleDigitNumber + 'A' - 1);
    mappedStrings(inp.substring(1), out + ch);

    if (inp.length() >= 2) {
        // Double digit number is possible
        int doubleDigitNumber = (inp.charAt(0) - '0') * 10 + (inp.charAt(1) - '0');
        if (doubleDigitNumber > 9 && doubleDigitNumber <= 26) {
            // If doubleDigitNumber is a double digit number i.e. does not have a 0 at 10s
            // place and less than 26 (number over 26 has no letter corresponding to it)
            ch = (char) (doubleDigitNumber + 'A' - 1);
            mappedStrings(inp.substring(2), out + ch);
        }
    }}
}
