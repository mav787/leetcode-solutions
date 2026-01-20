package old.C_Meta;

public class TTT121 {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
