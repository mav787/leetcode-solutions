package old.T200_299;
import java.util.*;

public class T247 {
	public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m) {
        if (n == 0) 
            return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) 
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> list = helper(n - 2, m);       // m : the original n
        
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            
            if (n != m) 
                res.add("0" + s + "0");     // get rid of nums starting with 0
            
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        
        return res;
    }
}
