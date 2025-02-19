package G_Salesforce.T1000_9999;
import java.util.*;

public class T1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> candidates = new HashMap<>();

        int left = 0, right = 0, res = 0;

        for(right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(right - left + 1 > minSize){
                char ch = s.charAt(left);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
                left++;
            }

            if(map.size() <= maxLetters && right - left + 1 == minSize){
                String candidate = s.substring(left, right + 1);
                candidates.put(candidate, candidates.getOrDefault(candidate, 0) + 1);
                res = Math.max(res, candidates.get(candidate));
            }
        }

        return res;
    }
}
