package FaceBook;
import java.util.*;
public class T17 {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return res;
        String[] dict = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(res, digits, dict, new StringBuilder());
        return res;
    }
    
    private void backtrack(List<String> res, String digits, String[] dict, StringBuilder sb){
        int len = sb.length();
        if(len == digits.length()){
            res.add(sb.toString());
            return;
        }
        
        int digit = digits.charAt(len) - '0';
        String button = dict[digit];
        for(int i = 0; i < button.length(); i++){
            sb.append(button.charAt(i));
            backtrack(res, digits, dict, sb);
            sb.setLength(len);
        }
    }
}
