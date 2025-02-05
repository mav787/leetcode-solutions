package C_Meta;

import java.util.Stack;

public class TT20 {
	public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
    	for (int i = 0; i < s.length(); i++) {
    	    char c = s.charAt(i);
    		if (c == '(')
    			stack.push(')');
    		else if (c == '{')
    			stack.push('}');
    		else if (c == '[')
    			stack.push(']');
    		else if (stack.isEmpty() || stack.pop() != c)
    			return false;
    	}
    	return stack.isEmpty();
    }
}
