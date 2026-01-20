package Z2025.T1_9;

import java.util.HashSet;
import java.util.Set;

public class T3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int res = 0;
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0;

        for(right = 0; right < s.length(); right++){
            while(left <= right && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
