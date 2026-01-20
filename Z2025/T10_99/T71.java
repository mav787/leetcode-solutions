package Z2025.T10_99;
import java.util.*;

public class T71 {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return path;
        }

        Deque<String> deque = new LinkedList<>();
        String[] sa = path.split("\\/");

        for(String s : sa){
            if(s.equals(".") || s.equals("")){
                continue;
            }
            else if(s.equals("..")){
                if(!deque.isEmpty()){
                    deque.pollFirst();;
                }
            }
            else{
                deque.offerFirst(s);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        while(!deque.isEmpty()){
            sb.append(deque.pollLast()).append("/");
        }

        sb.setLength(sb.length() - 1);

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
