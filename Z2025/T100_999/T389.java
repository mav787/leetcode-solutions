package Z2025.T100_999;

import java.util.*;

public class T389 {
    class Solution {
        public char findTheDifference(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for(char c : t.toCharArray()){
                if(!map.containsKey(c)){
                    return c;
                }
                map.put(c, map.get(c) - 1);
                if(map.get(c) == -1){
                    return c;
                }
            }
            return 'a';
        }
    }

}
