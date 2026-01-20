package old.C_Meta;

public class TT65 {
	public boolean isNumber(String s) {
        if(s == null || s.length() == 0)
            return false;
            
        s = s.trim();
        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasDigit = false;
        boolean num = true;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                hasDigit = true;
                num = true;
            } else if(s.charAt(i) == '.') {
                if(hasE || hasPoint) {
                    return false;
                }
                hasPoint = true;
            } else if(s.charAt(i) == 'e') {
                if(hasE || !hasDigit) {
                    return false;
                }
                num = false;
                hasE = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return hasDigit && num;
    }
}
