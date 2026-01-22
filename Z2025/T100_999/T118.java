package Z2025.T100_999;
import java.util.*;

public class T118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int n = numRows;
        if(n == 0){
            return res;
        }
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                dp[i][j] = j == 0 ? 1 : dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        for(int i = 0; i < n; i++){
            List<Integer> level = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                level.add(dp[i][j]);
            }
            res.add(level);
        }

        return res;
    }
}
