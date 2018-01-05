package T100_199;
import java.util.*;

public class T159 {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        // sliding window
        if(s == null) return -1;
        int res = 0, start = 0, end = 0;
        // map stores the index
        Map<Character, Integer> map = new HashMap<>();		// {char : lastIndex}
        while(end < s.length()){
            if(map.size() < 3){
                map.put(s.charAt(end), end);
                end++;
            }
            
            if(map.size() > 2){
                int leftMost = s.length();
                for(int i : map.values()){
                    leftMost = Math.min(leftMost, i);
                }
                map.remove(s.charAt(leftMost));
                start = leftMost + 1;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}
