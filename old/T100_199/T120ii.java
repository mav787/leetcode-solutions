package old.T100_199;
import java.util.*;
public class T120ii {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return -1;
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                else if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
