package old.C_Meta;
import java.util.*;
public class TT90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        Arrays.sort(nums);
        
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int index){
        res.add(new ArrayList<Integer>(subset));
        
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backtrack(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
