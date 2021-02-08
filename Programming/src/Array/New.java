package Array;

public class New {
	
	public static void main(String[] args) {
		int arr [][] = new int [5][];
		
		for (int i = 1 ; i < 5 ; i++) {
			int ans [] = new int [i];
			for (int j = 0 ; j < i ; j++) {
				ans[j] = 1;
			}
			arr [i-1] = ans;
		}
	}

}
