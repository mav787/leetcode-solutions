package Z2025.T10_99;
import java.util.*;


public class T32 {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int left = -1;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()){
                    left = i;
                }
                else{
                    stack.pop();
                    if(stack.isEmpty())
                        res = Math.max(res, i - left);
                    else
                        res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
