package old.Z_backtrack;

import java.util.*;

public class SubSet {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        if(nums == null || nums.length == 0){
            res.add(subset);
            return res;
        }
        System.out.println(computeSubsets(res, subset, 0, nums, new int[1]));
        return res;
    }
    
    private int computeSubsets(List<List<Integer>> res, List<Integer> subset, int start, int[] nums, int[] count){
    	count[0]++;
        res.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            computeSubsets(res, subset, i + 1, nums, count);
            subset.remove(subset.size() - 1);
        }
        return count[0];
    }
    
    public static void main(String[] args){
    	SubSet obj = new SubSet();
    	List<List<Integer>> res = obj.subsets(new int[]{1,2,3,4,5,6});
    }
}
