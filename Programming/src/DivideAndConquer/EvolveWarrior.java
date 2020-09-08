package DivideAndConquer;

import java.util.Scanner;

public class EvolveWarrior {
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		long warrior = sc.nextLong();
		long gems = sc.nextLong();
		long gemsReqToEvloveWarrior = sc.nextLong();
		long killNdGetGems = sc.nextLong();
		System.out.println(evolveWar(warrior,gems,gemsReqToEvloveWarrior,killNdGetGems));
	}

	private static long evolveWar(long warrior, long gems, long gemsReqToEvloveWarrior, long killNdGetGems) {
		long ans = 0;
		long left = 0;
		long right = warrior;
		
		while(left <= right) {
			long mid = (left+right)/2;	
			long totalGems = gems + (warrior - mid)*killNdGetGems;
			long remGems = totalGems - (mid*gemsReqToEvloveWarrior);
			
			if(remGems >= 0) {
				ans = mid;
				left = mid+1;
			} else {
				right = mid-1;
			}
			
		}	
		return ans;
	}

}
