package BitManipulation;

public class DifferentPairSplitWise {

	public static void main(String[] args) {
		int arr [] = {2,3};
		System.out.println(new DifferentPairSplitWise().cntBits(arr));
	}
	public int MOD = 1000000007;
	public int cntBits(int[] A) {

		Long ans = 0l;

		for (int bit = 0; bit <= 31; bit++) {
			int setBitsCount = 0;
			for (int index = 0; index < A.length; index++) {
				if ((A[index] & (1 << bit)) > 0) {
					setBitsCount++;
				}
			}
			ans += (2 * (setBitsCount%MOD * (A.length - setBitsCount)%MOD)%MOD)%MOD;
		}
		
		ans %= MOD;
		return ans.intValue();
	}

}
