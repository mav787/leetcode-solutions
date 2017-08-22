package T1_99;

public class T9My {
	public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = reverse(x);
        return x == y && y != Integer.MAX_VALUE;
    }
    
    private int reverse(int x){
        long y = 0;
        while(x != 0){
            y = y * 10 + x % 10;
            x /= 10;
            if(y > Integer.MAX_VALUE) 
                return Integer.MAX_VALUE;
        }
        return (int)y;
    }
}
