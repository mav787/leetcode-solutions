package old.C_Meta;

import java.util.*;


public class TTT301 {
	public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        if(s == null) return new ArrayList<String>(res);
        int lCount = 0, rCount = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') lCount++;
            else if(c == ')'){
                if(lCount > 0) lCount--;
                else rCount++;
            }
        }
        
        backtrack(res, new StringBuilder(), 0, lCount, rCount, s, 0);
        return new ArrayList<String>(res);
    }
    
    private void backtrack(Set<String> res, StringBuilder sb, int index, int lc, int rc, String s, int open){
        if(lc < 0 || rc < 0 || open < 0) return ;
        if(index == s.length()){
            if(lc == 0 && rc == 0 && open == 0){
                res.add(sb.toString());
            }
            return;
        }
        
        int len = sb.length();
        char c = s.charAt(index);
        if(c == '('){
            backtrack(res, sb, index + 1, lc - 1, rc, s, open);
            backtrack(res, sb.append("("), index + 1, lc, rc, s, open + 1);
        }
        else if(c == ')'){
            backtrack(res, sb, index + 1, lc, rc - 1, s, open);
            backtrack(res, sb.append(")"), index + 1, lc, rc, s, open - 1);
        }
        else{
            backtrack(res, sb.append(c), index + 1, lc, rc, s, open);
        }
        sb.setLength(len);
    }
}
