package T1_99;
import java.util.*;

public class TT90ii {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null)
            return res;
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, 0, new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int pos, boolean[] used){
        if(pos == nums.length){
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        
        if(used[pos])
            return;
        
        if(pos == 0 || used[pos - 1] || nums[pos] != nums[pos - 1]){
            subset.add(nums[pos]);
            used[pos] = true;
            backtrack(res, subset, nums, pos + 1, used);
            subset.remove(subset.size() - 1);
            used[pos] = false;
            backtrack(res, subset, nums, pos + 1, used);
        }
        else{
            backtrack(res, subset, nums, pos + 1, used);
        }
    }
}
