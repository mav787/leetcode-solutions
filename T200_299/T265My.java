package T200_299;

public class T265My {
	public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0)
            return 0;
        int n = costs.length, k = costs[0].length;
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[n][k];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                if(i == 0){
                    dp[i][j] = costs[i][j];
                }
                else{
                    int min = minPrice(dp, i - 1, j);
                    dp[i][j] = min + costs[i][j];
                }
                if(i == n - 1){
                    res = Math.min(res, dp[i][j]);
                }
            }
        }
        return res;
    }
    
    private int minPrice(int[][] dp, int i, int curr){
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < dp[i].length; j++){
            if(j == curr)
                continue;
            res = Math.min(res, dp[i][j]);
        }
        return res;
    }
}
