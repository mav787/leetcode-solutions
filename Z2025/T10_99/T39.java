package Z2025.T10_99;
import java.util.*;


public class T39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }

        backtrack(res, candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, int index, List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        if(target < 0 || index >= candidates.length){
            return;
        }

        for(int i = index; i < candidates.length; i++){
            list.add(candidates[i]);
            backtrack(res, candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
