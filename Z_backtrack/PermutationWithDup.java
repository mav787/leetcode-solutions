package Z_backtrack;
import java.util.*;

public class PermutationWithDup {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        Arrays.sort(nums);
        computePermutation(res, perm, nums, new boolean[nums.length]);
        return res;
    }
    
    private void computePermutation(List<List<Integer>> res, List<Integer> perm, int[] nums, boolean[] used){
        if(perm.size() == nums.length) {
            res.add(new ArrayList<Integer>(perm));
            return;
        }
            
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
                continue;
            if(used[i])
                continue;
            perm.add(nums[i]);
            used[i] = true;
            computePermutation(res, perm, nums, used);
            perm.remove(perm.size() - 1);
            used[i] = false;
        }
        
    }
}
