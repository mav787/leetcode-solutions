package old.T500_699;
import java.util.*;
public class T682 {
	public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(String s : ops){
            if(s.equals("C")){
                if(!stack.isEmpty()) stack.pop();
            }
            else if(s.equals("D")){
                if(!stack.isEmpty()) stack.push(stack.peek() * 2);
            }
            else if(s.equals("+")){
                if(stack.size() >= 2){
                    int first = stack.pop();
                    int second = stack.pop();
                    int sum = first + second;
                    
                    stack.push(second);
                    stack.push(first);
                    stack.push(sum);
                }
            }
            else{
                stack.push(Integer.valueOf(s));
            }
        }
        
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
