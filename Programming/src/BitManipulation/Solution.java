package BitManipulation;
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(new Solution().solve(10));
	}
	
   public int solve(int A) {
		int power = 0;
		boolean isAllSetBit = true;
		int num = A;
		int totalCol = A + 1;
		int ans = 0;
		while (num != 0) {
			if ((num & 1) == 0) {
				isAllSetBit = false;
				break;
			}
			num >>= 1;
		}

		num = A;

		while (num != 0) {
			ans = (ans% 1000000007 + findCountSetBit(totalCol, power, isAllSetBit)% 1000000007)% 1000000007;
			//System.out.println(ans);
			num >>= 1;
			power++;
		}

		return ans;
	}

	private int findCountSetBit(int num, int power, boolean isAllSetBit) {
		int count_set_bits = 0;
		// find total pairs
		int element_in_pair = (int) Math.pow(2, power);
		int totalPairs = (num / element_in_pair);

		// total pair for one's
		int pair_of_one = (totalPairs / 2);

		// compute total set bits in all pairs

		int pair_count = (int) Math.pow(2, power);

		count_set_bits = (pair_of_one * pair_count);
		if ((totalPairs & 1) == 1 && !isAllSetBit) {
			count_set_bits = (pair_of_one * pair_count) + (num % pair_count);
		}

		return (count_set_bits);
	}

    
}
