package T100_199;
import java.util.*;

public class T150 {
	public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            switch (s){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int i1 = stack.pop(), i2 = stack.pop();
                    stack.push(i2 - i1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop(), dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
