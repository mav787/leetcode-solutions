package old.T1_99;
import java.util.*;

public class TT22 {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0)
            return res;
        backtrack(res, n, 0, 0, new StringBuilder());
        return res;
    }
    
    private void backtrack(List<String> res, int n, int left, int right, StringBuilder sb){
        int len = sb.length();
        if(len == n * 2){
            res.add(sb.toString());
            return;
        }
        
        if(left < n){
            sb.append("(");
            backtrack(res, n, left + 1, right, sb);
            sb.setLength(len);
        }
        if(right < left){
            sb.append(")");
            backtrack(res, n, left, right + 1, sb);
            sb.setLength(len);
        }
    }
}
