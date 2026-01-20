package old.T1_99;
import java.util.*;

public class TT47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> perm, int[] nums, boolean[] used){
        if(perm.size() == nums.length){
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if(used[i])
                continue;
            used[i] = true;
            perm.add(nums[i]);
            backtrack(res, perm, nums, used);
            perm.remove(perm.size() - 1);
            used[i] = false;
        }
    }
}
