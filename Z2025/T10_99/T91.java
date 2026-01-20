package Z2025.T10_99;
import java.util.*;

public class T91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Set<String> set = new HashSet<>();
        for(int i = 1; i <= 26; i++){
            set.add(String.valueOf(i));
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 0; i < s.length(); i++){
            String singleChar = s.substring(i, i + 1);
            String doubleChar = i == 0 ? "" : s.substring(i - 1, i + 1);
            if(set.contains(singleChar)){
                dp[i + 1] += dp[i];
            }
            if(set.contains(doubleChar)){
                dp[i + 1] += dp[i - 1];
            }
        }

        return dp[n];
    }
}
