import java.util.Scanner;

public class DP_TSP {
	
	
	public static int VISITED_ALL;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		VISITED_ALL = (1 << n) -1;
		
	}
	
	public static int minCost(int mask, int city, int [][] arr) {
		if(mask == VISITED_ALL) {
			return arr[city][0];
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0 ; i < arr.length ; i++) {
			if ((mask & (1 << city)) == 0) {
				int newAns = arr[city][i] + minCost(mask|(1<<city),i, arr);
				ans = Math.max(ans, newAns);
			}
		}
		return ans;
	}
	

}
