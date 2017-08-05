package T200_299;
import java.util.*;
public class T288 {
	private Map<String, String> map;
    public T288(String[] dictionary) {
        map = new HashMap<>();
        for(String s : dictionary){
            String key = encode(s);
            if(map.containsKey(key)){
                if(!map.get(key).equals(s))
                    map.put(key, "");
            }
            else
                map.put(key, s);
        }
    }
    
    public boolean isUnique(String word) {
        if(!map.containsKey(encode(word)))
            return true;
        return map.get(encode(word)).equals(word);
    }
    
    private String encode(String s){
        if(s == null || s.length() < 3)
            return s;
        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }
}
