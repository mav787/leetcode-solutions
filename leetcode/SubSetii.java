package leetcode;

import java.util.*;

public class SubSetii {
	
	// JiGe's solution to subset I
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }
    
    // helper(index) <-- 

	private void helper(List<List<Integer>> res, ArrayList<Integer> subset, int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        
        subset.add(nums[index]);
        helper(res, subset, index + 1, nums);
        subset.remove(subset.size() - 1);
        
        helper(res, subset, index + 1, nums);
    }
	
	
	// with Duplicates : @lintcode 18
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        helper(res, subset, nums, 0);
        return res;
    }
    
    
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset, int[] nums, int index){
        res.add(new ArrayList<Integer>(subset));
        
        for(int i = index; i < nums.length; i++){
        	// this condition..
        	if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            helper(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
