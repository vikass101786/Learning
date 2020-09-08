package Recurssion;

public class PhoneKeypad {
	
	static char keypad [] [] = {{},
					{},
					{'A','B','C'},
					{'D','E','F'},
					{'G','H','I'},
					{'J','K','L'},
					{'M','N','O'},
					{'P','Q','R','S'},
					{'T','U','V'},
					{'W','X','Y','Z'}};
	
	static void printKeypadString(String in , char [] out , int i , int j) {
		if(in.length() == i) {
			System.out.println(out);
			System.out.print("======================== SubSequnce of ");
			System.out.println(out);
			char out1 [] = new char[out.length];
			subSequence(out, out1, 0, 0);
			System.out.println("==============================================");
			return;
		}
		
		int digit = Character.getNumericValue(in.charAt(i));
		
		if((digit == 1) || (digit == 0)) {
			printKeypadString(in, out, i+1, j);
		}
		
		for(int k = 0 ; k != keypad[digit].length ; k++) {
			out[j] = keypad[digit][k];
			printKeypadString(in, out, i+1, j+1);
		}
	}
	
	public static void main(String[] args) {
		String in = "234";
		char out [] = new char [100];
		printKeypadString(in, out, 0, 0);
	}
	
	static void subSequence(char in [] , char out [] , int i , int j) {
		
		if(in[i] == '\0') {
			out[j] = '\0';
			System.out.println(out);
			return;
		}
		
		
		out[j] = in[i];
		subSequence(in, out, i+1, j+1);
		subSequence(in, out, i+1, j);
	}
	
}
