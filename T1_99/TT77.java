package T1_99;
import java.util.*;

public class TT77 {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 0 || k <= 0 || k > n)
            return res;
        backtrack(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> combination, int n, int k, int start){
        if(combination.size() == k){
            res.add(new ArrayList<>(combination));
            return;
        }
        for(int i = start; i <= n; i++){
            combination.add(i);
            backtrack(res, combination, n, k, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
