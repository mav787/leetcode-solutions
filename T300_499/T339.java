package T300_499;

import java.util.List;

public class T339 {
	public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> nestedList, int depth){
        int res = 0;
        for(NestedInteger item : nestedList){
            if(item.isInteger()){
                res += item.getInteger() * depth;
            }
            else{
                res += (helper(item.getList(), depth + 1));
            }
        }
        return res;
    }
}

  
  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }