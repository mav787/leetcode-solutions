package Z_backtrack;
import java.util.*;

public class SubSetJiGe {
	public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        if(nums == null || nums.length == 0){
            res.add(subset);
            return res;
        }
        computeSubset(res, subset, nums, 0);
        return res;
    }
    
    private void computeSubset(ArrayList<List<Integer>> res, ArrayList<Integer> subset, int[] nums, int index){
        if(nums.length == index){
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        subset.add(nums[index]);
        computeSubset(res, subset, nums, index + 1);
        subset.remove(subset.size() - 1);
        computeSubset(res, subset, nums, index + 1);
    }
}
