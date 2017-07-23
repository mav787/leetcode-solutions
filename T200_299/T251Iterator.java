package T200_299;
import java.util.*;

public class T251Iterator implements Iterator<Integer> {
    
	private Iterator<List<Integer>> outerIter;
    private Iterator<Integer> innerIter;

    public T251Iterator(List<List<Integer>> vec2d) {
    	outerIter = vec2d.iterator();
    }

    public Integer next() {
        return innerIter.next();
    }

    public boolean hasNext() {
        while ((innerIter == null || !innerIter.hasNext()) && outerIter.hasNext())
        	innerIter = outerIter.next().iterator();
        return innerIter != null && innerIter.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */