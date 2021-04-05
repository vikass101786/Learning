package BitManipulation;

public class PrimeModuloInverse {
	
	/*long power(long x, long y, long p) 
    { 
        long res = 1;      // Initialize result 
      
        x = x % p;  // Update x if it is more than or 
                    // equal to p 
      
        while (y > 0) 
        { 
            // If y is odd, multiply x with result 
            if ((y & 1) == (long)1) 
                res = (res*x) % p; 
       
            y = y>>1; 
            x = (x*x) % p; 
        } 
        return res; 
    }    
    
    public int solve(int A, int B) {
        // Modular inverse of A Modulo B = pow(A, B-2, B)
        
        return (int)power(A, B-2, B);
    }*/

	
	public int solve(int A, int B) {
	       // Modular inverse of A Modulo B = pow(A, B-2, B)
	       return (int)power(A, B-2, B);
	    }
	    
	    public long power(long X , long Y , long Z) {
	        
	        long ans = 1;
	        
	        X = X % Z;
	        
	        while (Y != 0) {
	            
	            if ((Y & 1) == 1) {
	                ans = (ans * X) % Z;
	            }
	            
	            Y >>= 1;
	            X = (X * X) % Z;
	        }
	        
	        return ans;
	    }
    
    public static void main(String[] args) {
		System.out.println(new PrimeModuloInverse().solve(6, 23));
	}
}
