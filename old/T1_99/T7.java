package old.T1_99;

public class T7 {
	public int reverse(int x) {
        boolean isNegative = x < 0;
        if(isNegative) x = -x;
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        
        if(isNegative) res = -res;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        
        return (int)res;
    }
}
