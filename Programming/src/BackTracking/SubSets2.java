package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets2 {

	List<List<Integer>> answer = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		int nums [] = {1,2,2};
		System.out.println(new SubSets2().subsetsWithDup(nums));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<Integer> temp = new ArrayList<Integer>();
		subsetUtility1(nums, temp, 0);
		return answer;
	}

	public void subsetsUtility(int[] nums, List<Integer> temp, int vIdx) {

		if (vIdx == nums.length) {
			answer.add(new ArrayList<>(temp));
			return;
		}

		if (vIdx > nums.length) {
			return;
		}

		temp.add(nums[vIdx]);
		subsetsUtility(nums, temp, vIdx + 1);
		temp.remove(temp.size() - 1);
		subsetsUtility(nums, temp, vIdx + 1);
	}
	
	
	public void subsetUtility1(int [] nums, List<Integer> temp, int vIdx) {
		
			answer.add(new ArrayList<Integer>(temp));
		
		for (int i = vIdx ; i < nums.length ; i++)  {
			if (i > vIdx && nums[i] == nums[i-1])
				continue;
			
			temp.add(nums[i]);
			subsetUtility1(nums, temp, i+1);
			temp.remove(temp.size()-1);
		}
		
	}

}
