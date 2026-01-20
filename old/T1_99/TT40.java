package old.T1_99;
import java.util.*;

public class TT40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> combination, int[] candidates, int target, int start){
        if(target < 0)
            return;
        if(target == 0){
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1])
                continue;
            combination.add(candidates[i]);
            backtrack(res, combination, candidates, target - candidates[i], i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
