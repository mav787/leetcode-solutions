package Z2025.T100_999;

import java.util.*;

public class T290 {
    public boolean wordPattern(String pattern, String s) {
        if(s == null || s.length() == 0){
            return pattern.equals("");
        }

        int m = pattern.length();
        String[] words = s.split(" ");

        if(m != words.length){
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for(int i = 0; i < m; i++){
            char c = pattern.charAt(i);
            String word = words[i];

            if(!map1.containsKey(c)){
                if(map2.containsKey(word)){
                    return false;
                }

                map1.put(c, word);
                map2.put(word, c);
            }

            else{
                if(!map2.containsKey(word)){
                    return false;
                }

                if(!map1.get(c).equals(word) || map2.get(word) != c){
                    return false;
                }
            }
        }
        return true;
    }

}
