package E_Microsoft;
import java.util.*;
public class TT20 {
	public boolean isValid(String s) {
        if(s == null || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            
            else if(stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
