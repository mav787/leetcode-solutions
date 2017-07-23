package T100_199;

public class T161 {
	public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length() - t.length()) > 1)
            return false;
        int m = s.length(), n = t.length();
        if(m == n)
            return isOneModify(s, t);
        else if(m > n)
            return isOneDelete(s, t);
        else 
            return isOneDelete(t, s);
    }
    
    private boolean isOneModify(String s, String t){
        int diff = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i))
                diff++;
        }
        return diff == 1;
    }
    
    private boolean isOneDelete(String s, String t){
        int i = 0;
        while(i < t.length() && s.charAt(i) == t.charAt(i)){
            i++;
        }
        return i == t.length() || s.substring(i + 1).equals(t.substring(i));
    }
}
