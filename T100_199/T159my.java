package T100_199;
import java.util.*;

public class T159my {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        // sliding window
        if(s == null)
            return -1;
        if(s.length() < 3)
            return s.length();
        int res = 0, start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(end < s.length()){
            if(map.size() < 3){
                if(!map.containsKey(s.charAt(end))){
                    map.put(s.charAt(end), 1);
                }
                else{
                    map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
                }
                end++;
            }
                
            while(map.size() > 2){
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                }
                if(map.get(s.charAt(start)) == 0){
                    map.remove(s.charAt(start));
                }
                start++;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}
