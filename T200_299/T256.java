package T200_299;

public class T256 {
	public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0)
            return 0;
        int m = costs.length, n = costs[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < m; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        
        return Math.min(dp[m - 1][0], Math.min(dp[m - 1][1], dp[m - 1][2]));
    }
}
