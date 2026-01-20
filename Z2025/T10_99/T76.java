package Z2025.T10_99;
import java.util.*;

public class T76 {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()){
            return "";
        }
        int len = Integer.MAX_VALUE;
        String res = "";

        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0, right = 0;

        while(right < s.length()){
            char rc = s.charAt(right);
            sMap.put(rc, sMap.getOrDefault(rc, 0) + 1);

            while(isValid(sMap, tMap)){
                int candidate = right - left + 1;
                if(candidate <= len){
                    len = candidate;
                    res = s.substring(left, right + 1);
                }
                char lc = s.charAt(left);
                sMap.put(lc, sMap.get(lc) - 1);
                if(sMap.get(lc) == 0){
                    sMap.remove(lc);
                }
                left++;
            }

            right++;
        }

        return res;
    }

    private boolean isValid(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        // sMap >= tMap
        for(char c : tMap.keySet()){
            if(!sMap.containsKey(c)){
                return false;
            }
            if(sMap.get(c) < tMap.get(c)){
                return false;
            }
        }
        return true;
    }
}
