package old.T1_99;
import java.util.*;
public class TT13ii {
	public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        
        int res = 0;
        res += map.get(s.charAt(s.length() - 1));
        
        for(int i = 0; i < s.length() - 1; i++){
            int curr = map.get(s.charAt(i));
            int next = map.get(s.charAt(i + 1));
            if(curr < next){
                res -= curr;
            }
            else{
                res += curr;
            }
        }
        return res;
    }
}
