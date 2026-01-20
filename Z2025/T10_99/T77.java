package Z2025.T10_99;
import java.util.*;

public class T77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, k, 0, new ArrayList<Integer>(), new boolean[n]);
        return res;
    }

    private void helper(List<List<Integer>> res, int k, int index, List<Integer> list, boolean[] used){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < used.length; i++){
            if(!used[i]){
                used[i] = true;
                list.add(i + 1);
                helper(res, k, i + 1, list, used);

                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
