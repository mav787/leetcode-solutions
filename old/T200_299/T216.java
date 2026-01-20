package old.T200_299;
import java.util.*;

public class T216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < k)
            return res;
        backtrack(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> combination, int k, int target, int start){
        if(k == 0 && target == 0){
            res.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i = start; i <= 9; i++){
            combination.add(i);
            backtrack(res, combination, k - 1, target - i, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
