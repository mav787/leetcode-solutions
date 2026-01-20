package old.Z_backtrack;

import java.util.*;

public class SubSetii {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        // if(nums == null){
        //   res.add(subset);
        //   return res;
        //}
        Arrays.sort(nums);
        computeSubsets(res, subset, nums, 0);
        return res;
    }
    
    private void computeSubsets(List<List<Integer>> res, List<Integer> subset, int[] nums, int start){
        res.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            
            subset.add(nums[i]);
            computeSubsets(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
