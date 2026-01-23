package Z2025.T100_999;
import java.util.*;

public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }

        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // dp[i] : s[0, i) is good
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
