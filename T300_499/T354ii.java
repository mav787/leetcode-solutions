package T300_499;
import java.util.*;

public class T354ii {
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        
        int m = envelopes.length;
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
