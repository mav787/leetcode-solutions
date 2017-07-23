package T200_299;
import java.util.*;

public class T266ii {
	public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }
            else{
                set.remove(c);
            }
        }
        return set.size() == 0 || set.size() == 1;
    }
}
