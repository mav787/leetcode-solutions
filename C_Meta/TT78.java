package C_Meta;

import java.util.*;

public class TT78 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null)
            return res;
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int start){
        res.add(new ArrayList<>(subset));
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            backtrack(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
