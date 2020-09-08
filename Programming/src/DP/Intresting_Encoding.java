package DP;

import java.util.Scanner;

public class Intresting_Encoding {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int query = sc.nextInt();

		while (query-- > 0) {
			String str = sc.next();
			if(str == "0" || str == " ") {
				System.out.println(0);
			}else{
			System.out.println(interestingEncoding(str));
			}
		}
	}

	public static long interestingEncoding(String str) {

		long dp[] = new long[str.length() + 1];

		dp[0] = 1;

		for (int i = 1; i <= str.length(); i++) {

			long firstEnc = 0;
			long secondEnc = 0;

			if (valid(Character.getNumericValue(str.charAt(i-1)))) {
				firstEnc = dp[i - 1];
				//System.out.println(firstEnc);
			}

			if (i - 2 >= 0 && valid((Character.getNumericValue(str.charAt(i - 2)) * 10) + Character.getNumericValue(str.charAt(i-1))) && Character.getNumericValue(str.charAt(i - 2)) != 0) {
				secondEnc = dp[i - 2];
				//System.out.println(secondEnc);
			}
			dp[i] = firstEnc + secondEnc;
			//System.out.println("dp["+i+"]" + dp[i]);
		}
		return dp[str.length()];
	}

	public static boolean valid(int number) {
		//System.out.println("number " + number);
		return (number > 0 && number <= 26);
	}

}
