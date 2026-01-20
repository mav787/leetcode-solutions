package old.T200_299;

public class T233 {
	public int countDigitOne(int n) {
        if (n <= 0) 
            return 0;
        int q = n, x = 1, res = 0;
        
        while (q > 0){
            int digit = q % 10;
            q /= 10;
            
            res += q * x;
            if (digit == 1) 
                res += n % x + 1;
            if (digit > 1)
                res += x;
            x *= 10;
        }
        
        return res;
    }
}
