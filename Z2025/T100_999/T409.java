package Z2025.T100_999;

import java.util.*;

public class T409 {
    class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int res = 0;

            boolean hasOdd = false;

            for(char c : map.keySet()){
                if(map.get(c) % 2 == 0){
                    res += map.get(c);
                }
                else{
                    hasOdd = true;
                    res += map.get(c) - 1;
                }
            }

            return hasOdd ? res + 1 : res;
        }
    }
}
