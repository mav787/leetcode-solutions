package T1_99;

import java.util.*;

public class T3 {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, res = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                right++;
            }
            else{
                while(set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}