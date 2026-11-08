package Z2025.T100_999;

import java.util.*;

public class T340 {
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int res = 0;
            if(s == null || s.length() == 0){
                return 0;
            }

            int left = 0, right = 0;
            Map<Character, Integer> map = new HashMap<>();

            while(right < s.length()){
                char rc = s.charAt(right);
                map.put(rc, map.getOrDefault(rc, 0) + 1);
                right++;

                while(map.size() > k){
                    char lc = s.charAt(left);
                    map.put(lc, map.get(lc) - 1);
                    if(map.get(lc) == 0){
                        map.remove(lc);
                    }

                    left++;
                }

                res = Math.max(res, right - left);
            }

            return res;
        }
    }
}
