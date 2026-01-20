package old.T300_499;
import java.util.*;

public class T409 {
	public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int res = 0;
        boolean hasOdd = false;
        for(int times : map.values()){
            if(times % 2 == 0){
                res += times;
            }
            else{
                hasOdd = true;
                res += times - 1;
            }
        }
        
        return hasOdd ? res + 1 : res;
    }
}
