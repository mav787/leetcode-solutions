package D_Microsoft.T10_99;
import java.util.*;
public class T20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }
            else if(c == '['){
                stack.push(']');
            }
            else if(c == '{'){
                stack.push('}');
            }
            else{
                if(stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
