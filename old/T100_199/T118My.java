package old.T100_199;
import java.util.*;
public class T118My {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) return res;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if(numRows == 1) return res;
        for(int i = 1; i < numRows; i++){
            compLevel(res);
        }
        return res;
    }
    
    
    private void compLevel(List<List<Integer>> res){
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        List<Integer> prev = res.get(res.size() - 1);
        for(int i = 0; i < prev.size() - 1; i++){
            curr.add(prev.get(i) + prev.get(i + 1));
        }
        curr.add(1);
        res.add(curr);
    }
}
