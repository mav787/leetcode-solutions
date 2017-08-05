package T200_299;
import java.util.*;
public class T290 {
	public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] sa = str.split(" ");
        if(pattern.length() != sa.length)
            return false;
        for(int i = 0; i < pattern.length(); i++){
            char key = pattern.charAt(i);
            String val = sa[i];
            if(map.containsKey(key)){
                if(!map.get(key).equals(val))
                    return false;
            }
            else{
                if(map.containsValue(val))			// this is a handy API
                    return false;
                map.put(key, val);
            }
        }
        return true;
    }
}
