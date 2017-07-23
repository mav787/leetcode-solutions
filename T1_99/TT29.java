package T1_99;

public class TT29 {
	public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        if(dividend == 0)
            return 0;
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long ans = ldivide(ldividend, ldivisor);
        if(ans > Integer.MAX_VALUE){
            return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        return sign * (int)ans;
    }
    
    private long ldivide(long ldividend, long ldivisor) {
    	if (ldividend < ldivisor) return 0;
    	long dup = ldivisor;
    	long factor = 1;
    	while (ldividend >= dup << 1) {
    		dup <<= 1;
    		factor <<= 1;
    	}
    	//Look for additional value for the multiple from the reminder (dividend - sum) recursively.
    	return factor + ldivide(ldividend - dup, ldivisor);
    }
}
