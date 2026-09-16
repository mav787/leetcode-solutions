package Z2025.T100_999;

import java.util.*;

public class T288 {
    static class ValidWordAbbr {
        Map<String, Set<String>> map;

        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for(String s : dictionary){
                String key = getKey(s);
                Set<String> set = map.getOrDefault(key, new HashSet<>());
                set.add(s);
                map.put(key, set);
            }
        }

        public boolean isUnique(String word) {
            String key = getKey(word);
            if(!map.containsKey(key)){
                return true;
            }
            Set<String> set = map.get(key);
            return set.size() == 1 && set.contains(word);
        }

        private String getKey(String s){
            if(s.length() <= 2){
                return s;
            }

            return String.valueOf(s.charAt(0)) + String.valueOf(s.length() - 2) + String.valueOf(s.charAt(s.length() - 1));
        }
    }
}
