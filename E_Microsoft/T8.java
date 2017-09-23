package E_Microsoft;

public class T8 {
	public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        int sign = 1;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            if(str.charAt(0) == '-') sign = -1;
            str = str.substring(1);
        }
        long num = 0;
        for(int i = 0; i < str.length(); i++){
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit > 9) break;   // illegal
            num = num * 10 + digit;
            if(num > Integer.MAX_VALUE){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int)(sign * num);
    }
}
