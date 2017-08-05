package T200_299;
import java.util.*;
public class T293 {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 2) return res;
        char[] ca = s.toCharArray();
        for(int i = 0; i < ca.length - 1; i++){
            if(ca[i] == '+' && ca[i + 1] == '+'){
                ca[i] = '-';
                ca[i + 1] = '-';
                res.add(String.valueOf(ca));
                ca[i] = '+';
                ca[i + 1] = '+';
            }
        }
        return res;
    }
}
