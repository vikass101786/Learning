package Recurssion;

public class PowerFunction {
	
	static int mod = 1000000007;
	
	public static void main(String[] args) {
		System.out.println(calculatePower(2, 1000));
	}

	public static int calculatePower(long a , long b) {
		
		if (b == 1) {
			return (int)a;
		}
		
		long square = (a%mod * a%mod)%mod;
		
		if ((b & 1) == 1) {
			return (int)((a%mod) * calculatePower(square, b/2)%mod)%mod;
		} else {
			return calculatePower(square, b/2);
		}
		
	}
}
