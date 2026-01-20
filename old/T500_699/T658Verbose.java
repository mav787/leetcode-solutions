package old.T500_699;
import java.util.*;
public class T658Verbose {
	public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Collections.sort(arr, new Comparator<Integer>(){
            public int compare(Integer i, Integer j){
                if(Math.abs(i - x) == Math.abs(j - x)) return i - j;
                return Math.abs(i - x) - Math.abs(j - x);
            }
        });
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(arr.get(i));
        }
        Collections.sort(res);
        return res;
    }
}
