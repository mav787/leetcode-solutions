package T100_199;
import java.util.*;

public class T118 {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0)
            return res;
        if(numRows >= 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            res.add(list);
        }
        if(numRows >= 2){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            res.add(list);
        }
        if(numRows >= 3){
            for(int i = 3; i <= numRows; i++){
                generateRow(res, new ArrayList<>());
            }
        }
        return res;
        
    }
    
    private void generateRow(List<List<Integer>> res, List<Integer> level){
        level.add(1);
        List<Integer> abovelevel = res.get(res.size() - 1);
        for(int i = 0; i < abovelevel.size() - 1; i++){
            level.add(abovelevel.get(i) + abovelevel.get(i + 1));
        }
        level.add(1);
        res.add(level);
    }
}
