package T500_699;
import java.util.*;

public class T636 {
	public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] sa = logs.get(0).split(":");
        int previd = Integer.parseInt(sa[0]);
        int prevtime = Integer.parseInt(sa[2]);
        
        stack.push(previd);
        
        for(int i = 1; i < logs.size(); i++) {
            sa = logs.get(i).split(":");
            int id = Integer.parseInt(sa[0]);
			int time = Integer.parseInt(sa[2]);
            if(sa[1].equals("start")) {
                if(!stack.isEmpty()) { //check if there is no currently executing fn
                    previd = stack.peek();    
                    result[previd] += time - prevtime;
                }
                prevtime = time;
                stack.push(id);
            }
            else {
                previd = stack.pop();
                result[previd] += time - prevtime + 1;  
                prevtime = time + 1;
            }
        }
        
        return result;
    }
}
