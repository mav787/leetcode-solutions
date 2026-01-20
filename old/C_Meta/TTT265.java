package old.C_Meta;

public class TTT265 {
	public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];
        
        int min1 = -1, min2 = -1;
        
        for(int i = 0; i < n; i++){
            int prev1 = min1, prev2 = min2;
            min1 = -1;
            min2 = -1;
            for(int j = 0; j < k; j++){
                if(j == prev1){
                    dp[i][j] = costs[i][j] + (i == 0 ? 0 : dp[i - 1][prev2]);
                }
                else{
                    dp[i][j] = costs[i][j] + (i == 0 ? 0 : dp[i - 1][prev1]);
                }
                
                if(min1 < 0 || dp[i][j] < dp[i][min1]){
                    min2 = min1;
                    min1 = j;
                }
                else if(min2 < 0 || dp[i][j] < dp[i][min2]){
                    min2 = j;
                }
            }
        }
        
        return dp[n - 1][min1];
    }
}
