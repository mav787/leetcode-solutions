package old.T300_499;
import java.util.*;

public class T402 {
	public String removeKdigits(String num, int k) {
        if(num == null || num.length() < k || k < 0) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            while(!stack.isEmpty() && stack.peek() > c && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '0'){
            i++;
        }
        return i == sb.length() ? "0" : sb.toString().substring(i);
    }
}
