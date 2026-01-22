package Z2025.T100_999;

public class T122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices == null || prices.length <= 1){
            return res;
        }

        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= min){
                res += prices[i] - min;
                min = prices[i];
            }
            else{
                min = prices[i];
            }
        }

        return res;
    }
}
