package D_Microsoft.T100_999;

public class T121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }

        int res = 0;
        int min = prices[0];
        for(int i = 0; i < prices.length; i++){
            min = Math.min(prices[i], min);
            int profit = prices[i] - min;
            res = Math.max(profit, res);
        }
        return res;
    }
}
