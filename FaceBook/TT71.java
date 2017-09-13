package FaceBook;
import java.util.*;

public class TT71 {
	public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "/";
        Stack<String> stack = new Stack<>();
        String[] sa = path.split("/");
        for(int i = 0; i < sa.length; i++){
            if(sa[i].equals("") || sa[i].equals(".")) continue;
            if(sa[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(sa[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
