package T200_299;
import java.util.*;

public class T205 {
	public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set= new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i), tc = t.charAt(i);
            if(!map.containsKey(sc)){
                if(set.contains(tc))
                    return false;
                map.put(sc, tc);
                set.add(tc);
            }
            else{
                if(tc != map.get(sc))
                    return false;
            }
        }
        return true;
    }
}
