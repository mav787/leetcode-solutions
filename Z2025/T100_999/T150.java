package Z2025.T100_999;
import java.util.*;

public class T150 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                int i1 = stack.pop(), i2 = stack.pop();
                stack.push(i2 + i1);
            }
            else if(token.equals("-")){
                int i1 = stack.pop(), i2 = stack.pop();
                stack.push(i2 - i1);
            }
            else if(token.equals("*")){
                int i1 = stack.pop(), i2 = stack.pop();
                stack.push(i2 * i1);
            }
            else if(token.equals("/")){
                int i1 = stack.pop(), i2 = stack.pop();
                stack.push(i2 / i1);
            }
            else{
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
