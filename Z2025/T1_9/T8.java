package Z2025.T1_9;

public class T8 {
    public int myAtoi(String s) {
        long res = 0L;
        if(s == null || s.length() == 0){
            return 0;
        }

        s = s.trim();

        if(s.length() == 0){
            return 0;
        }
        int sign = 1;
        if(s.charAt(0) == '-'){
            sign = -1;
            s = s.substring(1);
        }
        else if(s.charAt(0) == '+'){
            sign = 1;
            s = s.substring(1);
        }

        for(int i = 0; i < s.length(); i++){
            int digit = s.charAt(i) - '0';
            if(digit == 0 && res == 0L){
                continue;
            }

            if(digit < 0 || digit >= 10){
                return (int) res * sign;
            }

            res = res * 10 + digit;
            if(res > (long)Integer.MAX_VALUE){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            else if(res == (long)Integer.MAX_VALUE){
                return Integer.MAX_VALUE * sign;
            }
        }

        return (int)res * sign;
    }
}
