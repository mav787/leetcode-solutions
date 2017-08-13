package T100_199;

public class T171 {
	public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res *= 26;
            res += s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
