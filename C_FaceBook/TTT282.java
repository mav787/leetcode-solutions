package C_FaceBook;
import java.util.*;

public class TTT282 {
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) 
            return res;
        backtrack(res, new StringBuilder(), num, target, 0, 0, 0);
        return res;
    }
    
    public void backtrack(List<String> res, StringBuilder sb, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                res.add(sb.toString());
            return;
        }
        
        for(int i = pos; i < num.length(); i++){
            int len = sb.length();
            
            if(i != pos && num.charAt(pos) == '0')  break;
            long cur = Long.valueOf(num.substring(pos, i + 1));	// slice
            if(pos == 0){
                backtrack(res, sb.append(cur), num, target, i + 1, cur, cur);
                sb.setLength(len);
            }
            
            else{
                backtrack(res, sb.append("+").append(cur), num, target, i + 1, eval + cur , cur);
                sb.setLength(len);
                backtrack(res, sb.append("-").append(cur), num, target, i + 1, eval - cur, -cur);
                sb.setLength(len);
                backtrack(res, sb.append("*").append(cur), num, target, i + 1, eval - multed + multed * cur, multed * cur );
                sb.setLength(len);
            }
        }
    }
}
