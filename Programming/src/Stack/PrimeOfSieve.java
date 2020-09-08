package Stack;

public class PrimeOfSieve {
	
	public static Long max_number = Long.MIN_VALUE;
	
	static void primeFactor(long n) { 
		int count = 0; 

		while (!(n % 2 > 0)) {  
			n >>= 1; 

			count++; 
		} 

		if (count > 0) { 
			if(max_number < 2l) {
			max_number = 2l;
			}
		} 

		for (long i = 3; i <= (long) Math.sqrt(n); i += 2) { 
			count = 0; 
			while (n % i == 0) { 
				count++; 
				n = n / i; 
			} 
			if (count > 0) { 
				if(max_number < i) {
					max_number = i;
				} 
			} 
		} 
 
		if (n > 2) { 
			if(max_number < n) {
				max_number = n;
			}
		}
		System.out.println(max_number);
	} 

	public static void main(String[] args) { 
		long n = 600851475143L; 
		primeFactor(n); 
	} 
}
