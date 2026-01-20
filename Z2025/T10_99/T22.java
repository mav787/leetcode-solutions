package Z2025.T10_99;
import java.util.*;

public class T22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, n, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, int left, int right, StringBuilder sb){
        if(left < 0 || right < 0 || left > right){
            return;
        }
        if(left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }

        int len = sb.length();
        sb.append('(');
        helper(res, left - 1, right, sb);
        sb.setLength(len);

        sb.append(')');
        helper(res, left, right - 1, sb);
        sb.setLength(len);
    }
}
