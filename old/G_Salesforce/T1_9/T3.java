package old.G_Salesforce.T1_9;
import java.util.*;

public class T3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            res = Math.max(res, set.size());
            right++;
        }

        return res;
    }
}
