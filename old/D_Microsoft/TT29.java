package old.D_Microsoft;

public class TT29 {
	public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;
        int sign = 1;
        if(dividend < 0 ^ divisor < 0) sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long res = ldivide(ldividend, ldivisor);
        if(res > Integer.MAX_VALUE){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign * (int)res;
    }
    
    private long ldivide(long ldividend, long ldivisor){
        if(ldividend < ldivisor) return 0;
        long curr = ldivisor;
        long factor = 1;
        while(ldividend > curr << 1){
            curr <<= 1;
            factor <<= 1;
        }
        return factor + ldivide(ldividend - curr, ldivisor);
    }
}
