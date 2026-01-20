package old.Z_backtrack;

import java.util.*;

public class SubSetWithCount {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        if(nums == null || nums.length == 0){
            res.add(subset);
            return res;
        }
        computeSubsets(res, subset, 0, nums);
        return res;
    }
    
    private void  computeSubsets(List<List<Integer>> res, List<Integer> subset, int start, int[] nums){
        res.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            computeSubsets(res, subset, i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
