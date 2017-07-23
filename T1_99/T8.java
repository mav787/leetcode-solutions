package T1_99;

public class T8 {
	public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int sign = 1, res = 0;
        str = str.trim();
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            sign = str.charAt(0) == '-'? -1 : 1;
            str = str.substring(1);
        }
        int len = str.length();
        for(int i = 0; i < len; i++){
            char c = str.charAt(i);
            if(c < '0' || c > '9')
                break;
            int digit = c - '0';
            if(Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit)){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
        }
        return sign * res;
    }
}
