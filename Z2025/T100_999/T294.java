package Z2025.T100_999;

import java.util.*;

public class T294 {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        return helper(s, new HashMap<String, Boolean>());
    }

    public boolean helper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String next = s.substring(0, i) + "--" + s.substring(i + 2);
                // next can't win
                if (!helper(next, map)) {
                    // we can win
                    map.put(s, true);
                    return true;
                }
            }
        }

        map.put(s, false);
        return false;
    }
}
