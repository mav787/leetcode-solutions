package old.T1_99;

public class TT50My {
	public double myPow(double x, int n) {
        return myPow(x, (long)n);
    }
    
    private double myPow(double x, long n){
        
        if(n == 0)
            return 1.0;
        
        boolean isNegativeN = n < 0;
        if(isNegativeN)
            n = -n;
        double inter = x;
        long curr = 1;
        while(curr << 1 <= n){
            inter = inter * inter;
            curr <<= 1;
        }
        
        if(curr == n){
            return isNegativeN ? 1.0 / inter : inter;    
        }
        
        double rest = myPow(x, n - curr);
        return isNegativeN? 1.0 / (inter * rest) : inter * rest;
    }
}
