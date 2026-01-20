package Z2025.T1_9;

public class T9 {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int y = reverse(x);
        return x == y;
    }

    private int reverse(int x){
        int y = 0;
        while(x > 0){
            int digit = x % 10;
            x /= 10;
            if((Integer.MAX_VALUE - digit) / 10 < y){
                return -1;
            }
            y = y * 10 + digit;
        }

        return y;
    }
}
