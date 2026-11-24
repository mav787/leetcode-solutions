package Z2025.T100_999;

import java.util.*;

public class T395 {
    class Solution {
        public int longestSubstring(String s, int k) {
            return helper(s, 0, s.length() - 1, k);
        }

        private int helper(String s, int left, int right, int k) {
            if(right - left + 1 < k){
                return 0;
            }

            int[] dict = new int[26];
            int res = 0;

            // Count character frequencies in the current substring.
            for(int i = left; i <= right; i++){
                dict[s.charAt(i) - 'a']++;
            }

            // Check whether the current substring contains invalid characters.
            for(int i = left; i <= right; i++){
                if(dict[s.charAt(i) - 'a'] < k){
                    res = Math.max(res, helper(s, left, i - 1, k));
                    res = Math.max(res, helper(s, i + 1, right, k));
                    return res;
                }
            }

            // Every character appears at least k times.
            return right - left + 1;
        }
    }

}
