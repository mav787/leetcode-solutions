package old.T200_299;
import java.util.*;
public class T282 {
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) 
            return res;
        backtrack(res, new StringBuilder(), num, target, 0, 0, 0);
        return res;
    }
    public void backtrack(List<String> res, StringBuilder sb, String num, int target, int pos, long value, long multed){
        if(pos == num.length()){
            if(target == value)
                res.add(sb.toString());
            return;
        }
        for(int i = pos; i < num.length(); i++){
            int len = sb.length();
            if(i != pos && num.charAt(pos) == '0') 		// trailing zeros at the beginning
                break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                backtrack(res, sb.append(cur), num, target, i + 1, cur, cur);
                sb.setLength(len);
            }
            
            else{
                backtrack(res, sb.append("+").append(cur), num, target, i + 1, value + cur , cur);
                sb.setLength(len);
                backtrack(res, sb.append("-").append(cur), num, target, i + 1, value - cur, -cur);
                sb.setLength(len);
                backtrack(res, sb.append("*").append(cur), num, target, i + 1, value - multed + multed * cur, multed * cur );
                sb.setLength(len);
            }
        }
    }
}
