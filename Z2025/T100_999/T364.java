package Z2025.T100_999;

import java.util.*;

public class T364 {

      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      public interface NestedInteger {
          // Constructor initializes an empty nested list.
          //public NestedInteger();
     
          // Constructor initializes a single integer.
          //public NestedInteger(int value);
     
          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();
     
          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();
     
          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value);
     
          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni);
     
          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return empty list if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
      }

    class Solution {
        int maxDepth = 0;

        public int depthSumInverse(List<NestedInteger> nestedList) {
            List<Helper> list = new ArrayList<>();
            expand(nestedList, list, 1);

            int res = 0;
            for(Helper item : list){
                res += item.val * (maxDepth - item.depth + 1);
            }

            return res;
        }



        private void expand(List<NestedInteger> nestedList, List<Helper> list, int depth){
            maxDepth = Math.max(maxDepth, depth);

            for(NestedInteger item : nestedList){
                if(item.isInteger()){
                    list.add(new Helper(item.getInteger(), depth));
                }
                else{
                    expand(item.getList(), list, depth + 1);
                }
            }
        }

        class Helper{
            int val;
            int depth;

            public Helper(int val, int depth){
                this.val = val;
                this.depth = depth;
            }
        }
    }

}
