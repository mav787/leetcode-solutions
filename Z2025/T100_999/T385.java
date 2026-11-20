package Z2025.T100_999;

import java.util.*;
public class T385 {
      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      class NestedInteger {
          // Constructor initializes an empty nested list.
          public NestedInteger() {

          }

          // Constructor initializes a single integer.
          public NestedInteger(int value) {

          }

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger() {
              return false;
          }

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger() {
              return null;
          }

          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value) {

          }

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni) {

          }

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return empty list if this NestedInteger holds a single integer
          public List<NestedInteger> getList() {
              return null;
          }
      }
    class Solution {
        public NestedInteger deserialize(String s) {
            return helper(s, 0, s.length() - 1);
        }

        private NestedInteger helper(String s, int start, int end) {
            if(s.charAt(start) != '['){
                return new NestedInteger(Integer.parseInt(s.substring(start, end + 1)));
            }

            NestedInteger res = new NestedInteger();

            int depth = 0;
            int left = start + 1;

            for(int i = start + 1; i < end; i++){
                char c = s.charAt(i);

                if(c == '['){
                    depth++;
                }
                else if(c == ']'){
                    depth--;
                }
                else if(c == ',' && depth == 0){
                    res.add(helper(s, left, i - 1));
                    left = i + 1;
                }
            }

            if(left < end){
                res.add(helper(s, left, end - 1));
            }

            return res;
        }
    }
}
