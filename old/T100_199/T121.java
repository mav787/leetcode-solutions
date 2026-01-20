package old.T100_199;

public class T121 {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int res = 0, minprice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minprice = Math.min(minprice, prices[i]);
            res = Math.max(res, prices[i] - minprice);
        }
        return res;
    }
}
