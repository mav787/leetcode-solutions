package Z2025.T100_999;
import java.util.*;

public class T159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;

        for(right = 0; right < s.length(); right++){
            char rc = s.charAt(right);
            map.put(rc, map.getOrDefault(rc, 0) + 1);

            while(map.size() > 2){
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1);
                if(map.get(lc) == 0){
                    map.remove(lc);
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
