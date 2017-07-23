package T1_99;
import java.util.*;

public class TT46 {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        backtrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> perm, int[] nums, boolean[] used){
        if(perm.size() == nums.length){
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
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
