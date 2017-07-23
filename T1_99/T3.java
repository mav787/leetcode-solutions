package T1_99;

import java.util.*;

public class T3 {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int left = 0, right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()){
            char c = s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                right++;
                max = Math.max(max, set.size());
            }
            else{
                while(set.contains(c)){
                    char ch = s.charAt(left);
                    set.remove(ch);
                    left++;
                }
            }
        }
        return max;
    }
}
