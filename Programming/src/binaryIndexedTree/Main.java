package binaryIndexedTree;

import java.util.Scanner;

class Main
{
	static int BIT [] ;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int a = 0 ; a < testCase ; a++) {
			
			int arrLen = sc.nextInt();
			int queryCount = sc.nextInt();
			
			BIT = new int [arrLen+1];

			for (int b = 0 ; b < queryCount ; b++ ) {
				int l = sc.nextInt()+1; int r = sc.nextInt()+1 ; int val = sc.nextInt() ;
				updateArr(l,val);
                updateArr(r+1,-val);
			}
			
			int query = sc.nextInt();
			
			for (int c = 0 ; c < query ; c++) {
				int search = sc.nextInt()+1;
				System.out.println(query(search));
			}
		}
		
	}
	
	
	public static void updateArr (int index, int value) {
		while(index < BIT.length) {
			BIT[index] += value;
			index +=(index & (-index));
		}
	}
	
	public static int query (int i) {
		// TODO Auto-generated method stub
		int ans = 0;
		while(i > 0) {
			ans += BIT[i];
			i -= (i & (-i));
		}
		//System.out.println(ans);
		return ans;
	}
	
}