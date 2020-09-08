package binaryIndexedTree;

public class BIT {
	// Range Sum Query
	static int arr [] = new int[] {0,8,2,1,4,3};
	static	int  BIT [] = new int [arr.length + 1];
	
	public static void main(String[] args) {
		BIT bit = new BIT();
		int K = 1;
		bit.buildBIT(arr, arr.length);
		int r = 4 , l = 1;
		
		
		System.out.println(query(r) - query(l-1));
	}
	
	public void updateArray(int i , int inc) {	
		while (i < BIT.length) {
			BIT[i] += inc;
			i +=((i) & (-i));
		}	
	}
	
	
	public void buildBIT(int [] arr , int n) {
		for(int i = 1 ; i < n ; i++) {
			updateArray(i, arr[i]);
		}
	}
	
	public static int query(int i) {
		int ans = 0 ;
		while (i > 0) {
			ans += BIT[i];
			i -= (i&(-i));
		}
		System.out.println(ans);
		return ans;
	}
	
}
