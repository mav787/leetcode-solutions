package T1_99;

public class T7 {
	public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        
        boolean isNegative = x < 0;
        if(isNegative) x = -x;
        long res = 0;
        int digit = 0;
        
        while (x != 0){
            digit = x % 10;
            x = x / 10;
            res = res * 10 + digit;
        }
        
        if(isNegative) res = -res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int) res;
    }
}
