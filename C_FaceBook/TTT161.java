package C_FaceBook;

public class TTT161 {
	public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length() - t.length()) > 1) return false;
        if(s.length() < t.length()) return isOneDelete(s, t);
        else if(s.length() == t.length()) return isOneModify(s, t);
        else return isOneDelete(t, s);
    }
    
    private boolean isOneDelete(String s, String t){
        // slen < tlen
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == t.charAt(i)) i++;
            else break;
        }
        if(i == s.length()) return true;
        return s.substring(i).equals(t.substring(i + 1));
    }
    
    private boolean isOneModify(String s, String t){
        int diff = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
}
