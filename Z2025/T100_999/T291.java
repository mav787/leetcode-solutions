package Z2025.T100_999;

import java.util.*;

public class T291 {
    public boolean wordPatternMatch(String pattern, String s) {
        return backtrack(pattern, 0, s, 0, new HashMap<Character, String>(), new HashMap<String, Character>());
    }

    private boolean backtrack(String pattern, int i, String s, int j, Map<Character, String> map1, Map<String, Character> map2){
        if(i == pattern.length() && j == s.length()){
            return true;
        }
        if(i == pattern.length() || j == s.length()){
            return false;
        }

        char c = pattern.charAt(i);
        if(map1.containsKey(c)){
            String word = map1.get(c);
            if(j + word.length() > s.length()){
                return false;
            }
            if(!word.equals(s.substring(j, j + word.length()))){
                return false;
            }
            return backtrack(pattern, i + 1, s, j + word.length(), map1, map2);
        }
        else{
            for(int k = j + 1; k <= s.length(); k++){
                String word = s.substring(j, k);
                if(map2.containsKey(word)){
                    continue;
                }

                map1.put(c, word);
                map2.put(word, c);

                if(backtrack(pattern, i + 1, s, k, map1, map2)){
                    return true;
                }

                map1.remove(c);
                map2.remove(word);
            }
        }

        return false;
    }
}
