package Maths;

public class ExtendedEuclideanAlgo {
	
	public static int x2 = 0;
	public static int y2 = 0;
	
	public static void main(String[] args) {
		int a = 3 , b = 7;
		int result = extendedGCD(a,b);
		
		System.out.println(" result = " + result +" ; x = " + x2 +" ; y = " + y2 );
	}

	private static int extendedGCD(int a, int b) {
		// TODO Auto-generated method stub
		
		if(b==0) {
			x2 = 1;
			y2 = 0;
			return a;
		}
		
		int result = extendedGCD(b, a%b);
		int x = 0, y = 0;
		x = y2;
		y = x2 - (a/b)*y2;
		
		x2 = x;
		y2 = y;
				
		return result;
	}
	
}
