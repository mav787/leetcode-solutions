package T1_99;

import java.util.*;

public class T3 {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            res = Math.max(res, set.size());
        }
        return res;
    }
}
