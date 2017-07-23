package T100_199;

public class T171 {
	public int titleToNumber(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int digit = (int)(s.charAt(i) - 'A') + 1;
            res = res * 26 + digit;
        }
        return res;
    }
}
