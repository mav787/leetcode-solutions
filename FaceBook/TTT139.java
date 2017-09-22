package FaceBook;
import java.util.*;

public class TTT139 {
	public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        if(wordDict == null || wordDict.size() == 0) return false;
        Set<String> dict = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
