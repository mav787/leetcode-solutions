package old.T200_299;
import java.util.*;

public class T294 {
	public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Map<String, Boolean> winMap = new HashMap<String, Boolean>();
        return helper(s, winMap);
    }

    public boolean helper(String s, Map<String, Boolean> winMap) {
        if (winMap.containsKey(s)) {
            return winMap.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i+2);
                if (!helper(t, winMap)) {
                    winMap.put(s, true);
                    return true;
                }
            }
        }
        winMap.put(s, false);
        return false;
    }
}
