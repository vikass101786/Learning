package binaryIndexedTree;

public class RangeMaxQuery {
	
	static int arr [] = new int[] {0,5,4,1,7,3};
	static	int  BIT [] = new int [arr.length + 1];
	
	public static void main(String[] args) {
		RangeMaxQuery bit = new RangeMaxQuery();
		int K = 1;
		bit.buildBIT(arr, arr.length);
		for(int i = 1 ; i < arr.length ; i++) {
			System.out.println(bit.query(i));
		}
	}
	
	
	
	public void buildBIT(int [] arr ,int len) {
		int i = 1 ;
		while (i < len) {
			update(arr[i] , i);
			i++;
		}
	}

	public void update(int value , int index) {
		// TODO Auto-generated method stub
	    int ans = 0;
		while (index < BIT.length) {
			BIT[index] = Math.max(value, ans);
			index += (index & (-index));
		}
	}
	
	public int query (int i) {
		int ans = 0;
		while (i > 0) {
			ans = Math.max(ans, BIT[i]);
			i -= (i & (-i));
		}		
		return ans;
	}
}
