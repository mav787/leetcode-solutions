package Z2025.T100_999;

import java.util.*;

public class T341 {
      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      public interface NestedInteger {
     
          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();
     
          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();
     
          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return empty list if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
      }

    public class NestedIterator implements Iterator<Integer> {
        List<Integer> list;
        Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            helper(nestedList, list);
            iterator = list.iterator();
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        private void helper(List<NestedInteger> nestedList, List<Integer> list) {
            for (NestedInteger item : nestedList) {
                if (item.isInteger()) {
                    list.add(item.getInteger());
                } else {
                    helper(item.getList(), list);
                }
            }
        }
    }
}
