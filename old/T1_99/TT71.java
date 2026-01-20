package old.T1_99;
import java.util.*;

public class TT71 {
	public String simplifyPath(String path) {
        if(path == null || path.length() == 0)
            return "";
        Stack<String> stack = new Stack<>();
        String[] sa = path.split("/");
        for(String s : sa){
            if(!stack.isEmpty() && s.equals("..")){
                stack.pop();
            }
            else if(s.equals("..") || s.equals("") || s.equals(".")){
                continue;
            }
            else{
                stack.push(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
