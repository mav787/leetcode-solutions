package T700_899;
import java.util.*;

public class T771 {
	public int numJewelsInStones(String J, String S) {
        if(J == null || S == null) return 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < J.length(); i++){
            set.add(J.charAt(i));
        }
        
        int res = 0;
        for(int i = 0; i < S.length(); i++){
            if(set.contains(S.charAt(i))){
                res++;
            }
        }
        return res;
    }
}
