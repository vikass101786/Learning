package BitManipulation;

public class UniqueElementInPairOfThree {
	public static void main(String[] args) {
		double a = 1<<3;
		double b = 1<<30;
		double c = a + b;
		System.out.println(c);
		int arr [] = {1,1,1,5,9,5,5};
		//System.out.println(solve(arr));
	}
	
	public static int solve (int arr []) {
		int n = arr.length;
		int ans = 0;
		
		for (int i = 0 ; i <= 31 ; i++) {
			int count = 0;
			for (int j = 0 ; j < n ; j++) {
				System.out.println(arr[j] +" & ( " + 1 +" << " + i +") = " + (arr[j] & (1 << i)));
				if ((arr[j] & (1 << i)) > 0) {
					count++;
				}
			}
			if (count % 3 == 0) {
				ans = ans | (1 << i);
			}
		}
		
		return ans;
	}
	
}
