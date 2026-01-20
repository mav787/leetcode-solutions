package old.T100_199;
import java.util.*;

public class T159my {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
    	if(s == null || s.length() == 0) return 0;
        int left = 0, right = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            char cr = s.charAt(right);
            if(map.size() <= 2){
                map.put(cr, map.getOrDefault(cr, 0) + 1);
                right++;
            }
            // illegal

            while(map.size() > 2){
                char cl = s.charAt(left);
                map.put(cl, map.get(cl) - 1);
                if(map.get(cl) == 0) map.remove(cl);
                left++;
            }
            res = Math.max(res, right - left);
		}
		return res;
    }
}
