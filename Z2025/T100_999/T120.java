package Z2025.T100_999;
import java.util.*;

public class T120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[2][n];

        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                int value = triangle.get(i).get(j);
                if(j == 0){
                    dp[i % 2][j] = value + dp[(i - 1) % 2][j];
                }
                else if(j == i){
                    dp[i % 2][j] = value + dp[(i - 1) % 2][j - 1];
                }
                else{
                    dp[i % 2][j] = value + Math.min(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - 1]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            res = Math.min(res, dp[(n - 1) % 2][j]);
        }
        return res;
    }
}
