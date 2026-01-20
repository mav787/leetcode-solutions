package old.C_Meta;
import java.util.*;
public class TTT341 implements Iterator<Integer> {

    private List<Integer> flattenedList;
    private Iterator<Integer> it;

    public TTT341(List<NestedInteger> nestedList) {
        flattenedList = new LinkedList<Integer>();
        flatten(nestedList);
        it = flattenedList.iterator();
    }

    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                flattenedList.add(i.getInteger());
            } else {
                flatten(i.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}
