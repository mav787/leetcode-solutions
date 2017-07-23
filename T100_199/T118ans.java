package T100_199;
import java.util.*;

public class T118ans {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0)
            return res;
        for(int i = 1; i <= numRows; i++){
            List<Integer> level = new ArrayList<>();
            for(int j = 1; j <= i; j++){
                if(j == 1 || j == i)
                    level.add(1);
                else{
                    level.add(res.get(i - 2).get(j - 2) + res.get(i - 2).get(j - 1));
                }
            }
            res.add(level);
        }
        return res;
    }
}
