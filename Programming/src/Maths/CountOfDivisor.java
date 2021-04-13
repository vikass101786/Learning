package Maths;

public class CountOfDivisor {
	
	public static void main(String[] args) {
		int arr [] = {2,3,4,5};
		System.out.println(new CountOfDivisor().solve1(arr));
	}

	public int[] solve(int[] A) {
		int ans[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			ans[i] = findDivisor(A[i]);
		}
		return ans;
	}

	public int findDivisor(int num) {

		int squareRoot = (int) Math.sqrt(num);

		int ans = 2;
		if (squareRoot * squareRoot == num) {
			ans = 1;
		}

		for (int i = 2; i <= squareRoot; i++) {
			if (num % i == 0) {
				ans += 2;
			}
		}
		return ans;
	}
	
int S[], SZ, NP = 1001001;
    
    void sieve() {
        int n = NP;
        S = new int[n];
        for(int i = 1; i < n; i++) 
            S[i] = i;
        for(int i = 2; i * i <= n; i++) 
        {
            if( S[i] != i )
                continue;
            for(int j = i * i; j < n; j += i) 
            {
                if(S[j] == j)
                    S[j] = i;
            }
        }
    }
    
    int countDivisors(int x) {
        int ans = 1;
        while(S[x] > 1) 
        {
            int cnt = 1, u = S[x];
            while(S[x] == u) 
            {
                cnt++;
                x /= u;
            }
            ans *= cnt;
        }
        return ans;    
    }
    
    public int[] solve1(int[] a)
    {
        sieve();
        int n = a.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++)
            ans[i] = countDivisors(a[i]);
        return ans;
    }

}
