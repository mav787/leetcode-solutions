package T200_299;
import java.util.*;

public class T251 implements Iterator<Integer> {
    
    private List<Integer> list;
    private int curr = 0;

    public T251(List<List<Integer>> vec2d) {
        list = new ArrayList<>();
        for(List<Integer> innerList : vec2d){
            list.addAll(innerList);
        }
    }

    @Override
    public Integer next() {
        int res = list.get(curr);
        curr++;
        return res;
    }

    @Override
    public boolean hasNext() {
        return curr < list.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */