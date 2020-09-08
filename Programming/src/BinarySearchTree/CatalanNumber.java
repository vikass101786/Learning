package BinarySearchTree;

public class CatalanNumber {
	
	static int [] dp = new int[100];
	
	static int computeCatalan(int n) {
		if(n == 0) return 1;
		int ans = 0;
		for(int i = 1 ; i <= n ; i++) {
			ans += computeCatalan(i-1) * computeCatalan(n-i);
		}
		return ans;
	}

	static int computeCatalanDP(int n) {
		
		if(n == 0) {
			dp[0] = 1;
			return dp[0];
		}
		
		if(dp[n] != 0) {
			return dp[n];
		}
		int ans = 0;
		for(int i = 1 ; i <= n ; i++) {
			ans += computeCatalanDP(i-1) * computeCatalanDP(n-i);
		}
		dp[n] = ans;
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(computeCatalan(5));
		System.out.println(computeCatalanDP(5));
	}
	
}
