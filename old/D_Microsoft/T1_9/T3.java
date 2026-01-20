package old.D_Microsoft.T1_9;

import java.util.HashSet;
import java.util.Set;

public class T3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int res = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, set.size());
            }
            else{
                while(i < j && set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return res;
    }
}
