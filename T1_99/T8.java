package T1_99;

public class T8 {
	public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        int sign = 1;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            if(str.charAt(0) == '-'){
                sign = -1;
            }
            str = str.substring(1);
        }
        
        long res = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c < '0' || c > '9') break;
            res = res * 10 + c - '0';
            if(res > Integer.MAX_VALUE){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return sign * (int)res;
    }
}
