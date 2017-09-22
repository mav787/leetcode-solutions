package FaceBook;
import java.util.*;

public class TT71 {
	public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "/";
        String[] sa = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(String s : sa){
            s = s.trim();
            if(s.length() == 0 || s.equals(".")) continue;
            if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else{
                stack.push(s);
            }
        }
        
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
