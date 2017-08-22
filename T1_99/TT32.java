package T1_99;
import java.util.*;

public class TT32 {
	public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int left = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) =='(') 
                stack.push(i);            
            else {
                if (stack.isEmpty()) 
                    left = i;
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
