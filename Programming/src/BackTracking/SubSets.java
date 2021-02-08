package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
	
	List<List<Integer>> answer = new ArrayList<List<Integer>>();
	List<List<Integer>> alist = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		int arr [] = {1,2,3};
		new SubSets().subsets1(arr);
		int arr1 [] = {0};
		new SubSets().subsets1(arr1);
	}
	
	public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        subsetsUtility(nums,temp,0);
        return answer;
    }
    
    
    public void subsetsUtility(int [] nums, List<Integer> temp , int vIdx) {
        
        if(vIdx == nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        
        if(vIdx > nums.length) {
            return;
        }
        
        temp.add(nums[vIdx]);
        subsetsUtility(nums,temp,vIdx+1);
        temp.remove(temp.size() -1);
        subsetsUtility(nums,temp,vIdx+1);
    }
    
    public List<List<Integer>> subsets1(int[] nums) {
        int n=nums.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer> list=new ArrayList();
            
            for(int j=0;j<n;j++){
                if((i &(1<<j))>0)
                    list.add(nums[j]);
              }
           alist.add(list) ;
      }
      
      return alist;
  }
    

}
