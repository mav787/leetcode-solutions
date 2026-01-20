package Z2025.T10_99;
import java.util.*;

public class T40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }

        Arrays.sort(candidates);
        backtrack(candidates, res, 0, target, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, List<List<Integer>> res, int index, int target, List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(i != index && candidates[i] == candidates[i - 1]){
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, res, i + 1, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
