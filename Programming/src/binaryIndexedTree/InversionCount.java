package binaryIndexedTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class InversionCount {
	
	static int arr [] = new int[] {0,8,2,1,4,3};
	static int BIT [] ;
	
	public static void main(String[] args) {
	Set set =	new TreeSet();
	set.addAll(Arrays.asList(BIT));
	Map map = new HashMap();
	
		int max = arr[0];
		for (int i= 1 ; i < arr.length ; i++) {
			max = Math.max(max, arr[i]);
		}
		BIT = new int [max+1];
		
		InversionCount inc = new InversionCount();
		int ans = 0;
		for (int i = arr.length -1 ; i >= 1 ; i--) {
			ans += inc.query(arr[i]);
			System.out.println(arr[i] +"------"+ ans);
			inc.update(arr[i],1,BIT);
		}
		System.out.println(ans);
	}

	public  void update(int index, int inc , int [] bitArr) {
		// TODO Auto-generated method stub
		while(index < bitArr.length) {
			BIT[index] += inc;
			index += (index & (-index));
		}
		
	}

	public int query(int i) {
		// TODO Auto-generated method stub
		int ans = 0;
		while(i > 0) {
			ans += BIT[i];
			i -= (i & (-i));
		}
		System.out.println(ans);
		return ans;
	}
	
	
	
}
