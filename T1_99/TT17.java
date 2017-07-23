package T1_99;
import java.util.*;

public class TT17 {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return res;
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(res, dict, digits, new StringBuilder());
        return res;
    }
    
    private void backtrack(List<String> res, String[] dict, String digits, StringBuilder sb){
        int len = sb.length();
        if(len == digits.length()){
            res.add(sb.toString());
            return;
        }
        int index = digits.charAt(len) - '0';
        String button = dict[index];
        for(int i = 0; i < button.length(); i++){
            sb.append(button.charAt(i));
            backtrack(res, dict, digits, sb);
            sb.setLength(len);
        }
    }
}
