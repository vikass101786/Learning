package Recurssion;

public class VeryLargePower {
	
	public static void main(String[] args) {
		System.out.println(new VeryLargePower().solve(2, 27));
	}

    public int solve(int A, int B) {
        Long power = fact(B);
        return fastPower(Long.valueOf(A),power);
    }
    
    public int MOD = 1000000007;
    
    public int fastPower(Long A , Long power) {
        
        if (power == 1) {
            return A.intValue();
        }
        
        Long square = ((A%MOD) * (A%MOD))%MOD;
        
        if ((power & 1) == 1) {
            Long ans = ((A%(MOD)) * (fastPower(square,power/2)%MOD))%MOD;
            return ans.intValue();
        } else {
            return fastPower(square,power/2);
        }
        
    }
    
    private long fact(int B) {
        
        Long ans = 1l;
        
        for (int i = 1 ; i <= B ; i++) {
            ans = (ans%MOD * i%MOD)%MOD;
        }
        
        return ans;
    }

}
