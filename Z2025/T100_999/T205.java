package Z2025.T100_999;
import java.util.*;

public class T205 {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }

        return helper(s, t) && helper(t, s);
    }

    private boolean helper(String s, String t){
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if(!map.containsKey(cs)){
                map.put(cs, ct);
            }
            else{
                if(map.get(cs) != ct){
                    return false;
                }
            }
        }

        return true;
    }
}
