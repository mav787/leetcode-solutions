package old.T1_99;
import java.util.*;

public class TT22My {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n, n);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder sb, int open, int close){
        if(open == 0 && close == 0){
            res.add(sb.toString());
            return;
        }
        if(open < 0 || close < 0 || open > close){
            return;
        }
        sb.append('(');
        backtrack(res, sb, open - 1, close);
        sb.setLength(sb.length() - 1);
        
        sb.append(')');
        backtrack(res, sb, open, close - 1);
        sb.setLength(sb.length() - 1);
    }
}
