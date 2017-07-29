package T200_299;
import java.util.*;

public class T281 {
	private int counter = 0;
    private int size = 0;
    private List<Iterator<Integer>> iters = new ArrayList<>();
    public T281(List<Integer> v1, List<Integer> v2) {
        List<List<Integer>> nestedList = new ArrayList<>();
        nestedList.add(v1);
        nestedList.add(v2);
        
        for(List<Integer> list : nestedList){
            Iterator<Integer> iter = list.iterator();
            iters.add(iter);
        }
        size = nestedList.size();
    }

    public int next() {
        while(!iters.get(counter).hasNext())
            counter = (counter + 1) % size;
        int res = iters.get(counter).next();
        counter = (counter + 1) % size;
        return res;
        
    }

    public boolean hasNext() {
        boolean res = false;
        for(int i = 0; i < iters.size(); i++){
            res = res || iters.get(i).hasNext();    
        }
        return res;
    }
}
