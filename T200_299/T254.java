package T200_299;
import java.util.*;

public class T254 {
	public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 3)  
        	return res;
        backtrack(res, new ArrayList<Integer>(), 2, n);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int start, int n){
       for(int i = start; i <= Math.sqrt(n); i++){
           if(n % i == 0){  
               path.add(i);
               path.add(n / i);
               
               res.add(new ArrayList<Integer>(path));
               
               path.remove(path.size() - 1);
               backtrack(res, path, i, n / i);
               
               path.remove(path.size() - 1);
           }
       }
    }
}
