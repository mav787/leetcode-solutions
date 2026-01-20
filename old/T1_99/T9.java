package old.T1_99;

public class T9 {
	public boolean isPalindrome(int x) {
        if (x < 0) 
        	return false;
        int p = x, q = 0; 
        while (p >= 10){
            q = q * 10 + p % 10;
            p = p / 10;
        }
        return q == x / 10 && p == x % 10;
    }
}
