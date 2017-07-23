package T1_99;

import java.util.*;

public class TT90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null)
            return res;
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int start){
        res.add(new ArrayList<>(subset));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1])
                continue;
            subset.add(nums[i]);
            backtrack(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
