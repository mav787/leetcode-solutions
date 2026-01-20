package old.T200_299;
import java.util.*;

public class T227 {
    public int calculate(String s) {
        s = s.trim();
        if(s == null || s.length() == 0)
            return 0;
        char[] ca = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        // sign remembers the previous operator
        char sign = '+';
        for(int i = 0 ; i < ca.length; i++){
            char c = ca[i];
            if(c == ' ') {
                continue;
            }
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }

            else{
                // sign remembers the previous operator
                if(sign == '-'){
                    stack.push(-curr);
                }
                else if(sign == '+'){
                    stack.push(curr);
                }
                else if(sign == '*'){
                    stack.push(stack.pop() * curr);
                }
                else if(sign == '/'){
                    stack.push(stack.pop() / curr);
                }
                // update the current sign
                sign = c;
                curr = 0;
            }
        }

        // last time
        if(sign == '-'){
            stack.push(-curr);
        }
        else if(sign == '+'){
            stack.push(curr);
        }
        else if(sign == '*'){
            stack.push(stack.pop() * curr);
        }
        else if(sign == '/'){
            stack.push(stack.pop() / curr);
        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
