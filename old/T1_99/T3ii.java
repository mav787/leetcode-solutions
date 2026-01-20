package old.T1_99;

import java.util.*;

public class T3ii {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()){
            char c = s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                res = Math.max(res, set.size());
                right++;
            }
            else{
                while(set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return res;
    }
}
