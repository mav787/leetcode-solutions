package old.T1_99;
import java.util.*;

public class TT39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return res;
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> combination, int[] candidates, int target, int start){
        if(target == 0){
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        if(target < 0)
            return;
        for(int i = start; i < candidates.length; i++){
            combination.add(candidates[i]);
            backtrack(res, combination, candidates, target - candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}
