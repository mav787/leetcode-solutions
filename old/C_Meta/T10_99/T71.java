package old.C_Meta.T10_99;

import java.util.*;

public class T71 {
    public String simplifyPath(String path) {
        if(path == null || path.length() <= 1){
            return path;
        }

        String[] paths = path.split("/");

        Deque<String> deque = new LinkedList<>();

        for(String s : paths){
            if(s.length() == 0 || s.equals(".")){
                continue;
            }
            else if(s.equals("..")){
                if(!deque.isEmpty()){
                    deque.pollLast();
                }
            }
            else{
                deque.offerLast(s);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!deque.isEmpty()){
            sb.append("/").append(deque.pollFirst());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
