package backtrack;
import java.util.*;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        computePermutation(res, perm, nums);
        return res;
    }
    
    private void computePermutation(List<List<Integer>> res, List<Integer> perm, int[] nums){
        if(perm.size() == nums.length){
            res.add(new ArrayList<Integer> (perm));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(perm.contains(nums[i])) 
            	continue;
            perm.add(nums[i]);
            computePermutation(res, perm, nums);
            perm.remove(perm.size() - 1);
        }
    }
}
