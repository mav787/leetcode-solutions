package old.T200_299;
import java.util.*;
public class T282ii {
	public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        if (num.length() == 0) return res;
        char[] path = new char[num.length() * 2 - 1];
        char[] digits = num.toCharArray();
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            backtrack(res, path, i + 1, 0, n, digits, i + 1, target);
            if (n == 0) break;
        }
        return res;
    }
    private void backtrack(List<String> res, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
        if (pos == digits.length) {
            if (left + cur == target) res.add(new String(path, 0, len));
            return;
        }
        long n = 0;
        int j = len + 1;
        for (int i = pos; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[j++] = digits[i];
            path[len] = '+';
            backtrack(res, path, j, left + cur, n, digits, i + 1, target);
            path[len] = '-';
            backtrack(res, path, j, left + cur, -n, digits, i + 1, target);
            path[len] = '*';
            backtrack(res, path, j, left, cur * n, digits, i + 1, target);
            if (digits[pos] == '0') 
            	break; 
        }
    }
}
