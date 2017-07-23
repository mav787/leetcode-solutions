package T1_99;
import java.util.*;

public class TT93 {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        backtrack(res, s, 0, new String[4], 0);
        return res;
    }
    
    private void backtrack(List<String> res, String s, int pos, String[] sa, int curr){
        if(curr == 4 && pos != s.length())
            return;
        
        if(curr == 4 && pos == s.length()){
            StringBuilder sb = new StringBuilder();
            sb.append(sa[0]);
            for(int i = 1; i < 4; i++){
                sb.append(".").append(sa[i]);
            }
            res.add(sb.toString());
            return;
        }
        
        for(int i = 1; i <= 3 && pos + i <= s.length(); i++){
            String sub = s.substring(pos, pos + i);
            if(sub.length() > 1 && sub.charAt(0) == '0')
                continue;
            int num = Integer.valueOf(sub);
            if(num >= 0 && num <= 255){
                sa[curr] = sub;
                backtrack(res, s, pos + i, sa, curr + 1);
            }
        }
    }
}
