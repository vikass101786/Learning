package Stack;

public class PalindromeOfNdigit {
	static int Palindrome(int n) 
	{ 
		int max = 0; 
	 
		for (int i=1; i<=n; i++) 
		{ 
			max *= 10; 
			max += 9; 
		} 
	 
		int min = 1 + max / 10; 
	
		int max_out = 0; 
		
		for (int i = max; i >= min; i--) 
		{ 
			for (int j = i; j >= min; j--) 
			{  
				int multiply = i * j; 
				if (multiply < max_out) 
					break; 

				if (multiply == reverseMul(multiply) && multiply > max_out) 
					max_out = multiply; 
			} 
		} 
		return max_out; 
	} 

	private static int reverseMul(int multiply) {
		int reverse = 0; 
		while (multiply != 0) 
		{ 
			reverse = reverse * 10 + multiply % 10; 
			multiply /= 10; 
		} 
		return reverse;
	}

	public static void main (String[] args) 
	{ 
	
		int n = 3; 
		System.out.print(Palindrome(n)); 
	} 
}		
