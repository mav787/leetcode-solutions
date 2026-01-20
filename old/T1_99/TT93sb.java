package old.T1_99;
import java.util.*;

public class TT93sb {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length () == 0)
            return res;
        backtrack(res, s, 0, new StringBuilder(), 0);
        return res;
    }
    
    private void backtrack(List<String> res, String s, int pos, StringBuilder sb, int curr){
        int len = sb.length();
        
        if(curr == 4 && pos != s.length())
            return;
        
        if(curr == 4 && pos == s.length()){
            sb.setLength(len - 1);  // delete the last "."
            res.add(sb.toString());
            return;
        }
        
        for(int i = 1; i <= 3 && pos + i <= s.length(); i++){
            String sub = s.substring(pos, pos + i);
            if(sub.length() > 1 && sub.charAt(0) == '0')
                continue;
            int num = Integer.valueOf(sub);
            if(num >= 0 && num <= 255){
                sb.append(sub).append(".");
                backtrack(res, s, pos + i, sb, curr + 1);
                sb.setLength(len);
            }
        }
    }
}
