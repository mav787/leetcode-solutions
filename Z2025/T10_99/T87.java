package Z2025.T10_99;
import java.util.*;

public class T87 {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null && s2 == null){
            return true;
        }
        if(s1 == null || s2 == null){
            return false;
        }

        return helper(s1, s2, new HashMap<String, Boolean>());
    }

    private boolean helper(String s1, String s2, Map<String, Boolean> map){
        String key = s1 + "#" + s2;
        if(map.containsKey(key)){
            return map.get(key);
        }

        if(s1.length() != s2.length() || !hasSameLetters(s1, s2)){
            map.put(key, false);
            return false;
        }
        if(s1.equals(s2)){
            map.put(key, true);
            return true;
        }

        for(int i = 1; i < s1.length(); i++){
            String s1l = s1.substring(0, i), s1r = s1.substring(i);
            String s2l1 = s2.substring(0, i), s2r1 = s2.substring(i);
            if(helper(s1l, s2l1, map) && helper(s1r, s2r1, map)){
                map.put(key, true);
                return true;
            }

            String s2l2 = s2.substring(s2.length() - i, s2.length()), s2r2 = s2.substring(0, s2.length() - i);
            if(helper(s1l, s2l2, map) && helper(s1r, s2r2, map)){
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }


    private boolean hasSameLetters(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
