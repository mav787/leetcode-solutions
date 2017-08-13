package T200_299;

public class T256My {
	public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) return 0;
        int m = costs.length, n = costs[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < n; i++){
            dp[0][i] = costs[0][i];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                int former = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(k == j) continue;    // same color
                    former = Math.min(former, dp[i - 1][k]);
                }
                dp[i][j] = costs[i][j] + former;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }
}
