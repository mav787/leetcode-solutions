package T1_99;
import java.util.*;

public class TT17 {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String[] sa = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        backtrack(res, sa, digits, 0, new StringBuilder());
        return res;
    }
    
    private void backtrack(List<String> res, String[] sa, String digits, int pos, StringBuilder sb){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        
        String button = sa[digits.charAt(pos) - '0'];
        for(int i = 0; i < button.length(); i++){
            sb.append(button.charAt(i));
            backtrack(res, sa, digits, pos + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
