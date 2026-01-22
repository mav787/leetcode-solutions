package Z2025.T100_999;

public class T121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices == null || prices.length <= 1){
            return res;
        }

        int min = prices[0];

        for(int i = 1; i < prices.length; i++){
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return res;
    }
}
