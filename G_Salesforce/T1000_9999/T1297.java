package G_Salesforce.T1000_9999;
import java.util.*;

public class T1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // maxSize is not used in this question
        int left = 0, right = 0;
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> candidates = new HashMap<>();

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while ((right - left + 1) > minSize) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }

            if (map.size() <= maxLetters && right - left + 1 == minSize) {
                String key = s.substring(left, right + 1);
                candidates.put(key, candidates.getOrDefault(key, 0) + 1);
                res = Math.max(res, candidates.get(key));
            }
            right++;
        }
        return res;
    }
}
