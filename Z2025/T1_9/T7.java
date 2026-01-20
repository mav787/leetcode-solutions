package Z2025.T1_9;

public class T7 {
    public int reverse(int x) {
        if(x == 0 || x == Integer.MIN_VALUE) return 0;
        int sign = 1;
        if(x < 0){
            sign = -1;
            x = -x;
        }

        return sign * reversePositive(x);
    }

    private int reversePositive(int x){
        int res = 0;
        while(x > 0){
            int digit = x % 10;
            x = x / 10;

            if((Integer.MAX_VALUE - digit) / 10 < res) {
                return 0;
            }
            res = res * 10 + digit;
        }

        return res;
    }
}
