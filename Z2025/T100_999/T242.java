package Z2025.T100_999;
import java.util.*;

public class T242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }

            map.put(c, map.get(c) - 1);
            if(map.get(c) == 0){
                map.remove(c);
            }
        }

        return map.isEmpty();
    }
}
