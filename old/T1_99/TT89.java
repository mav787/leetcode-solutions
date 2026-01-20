package old.T1_99;
import java.util.*;

public class TT89 {
	public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n < 0)
            return res;
        res.add(0);
        for(int i = 0; i < n; i++){					// loop through all bits.
            int size = res.size();
            for(int k = size - 1; k >= 0; k--){     // reverse order to maintain the order
                res.add(res.get(k) | (1 << i));   	// set a single fixed bit (build from 0) in the whole list;  				
            }                                       // the bit that get set is always the initial one.
        }
        return res;
    }
}
