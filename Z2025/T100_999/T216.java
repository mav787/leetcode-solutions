package Z2025.T100_999;
import java.util.*;

public class T216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, k, n, 1, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int k, int target, int start, List<Integer> list){
        if(target < 0 || k < 0){
            return;
        }

        if(target == 0 && k == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = start; i <= 9; i++){
            list.add(i);
            helper(res, k - 1, target - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
