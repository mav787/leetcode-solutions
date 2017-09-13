package FaceBook;
import java.util.*;

public class T139 {
	public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null || wordDict.size() == 0)
            return false;
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String sub = s.substring(j, i);
                if(dp[j] && set.contains(sub)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
