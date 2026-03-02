package Z2025.T100_999;
import java.util.*;

public class T254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 1){
            return res;
        }

        helper(res, n, 2, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int n, int start, List<Integer> list){
        for(int i = start; i * i <= n; i++){
            if(n % i == 0){
                list.add(i);
                list.add(n / i);
                res.add(new ArrayList<>(list));


                list.remove(list.size() - 1);
                helper(res, n / i, i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
