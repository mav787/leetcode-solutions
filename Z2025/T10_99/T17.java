package Z2025.T10_99;
import java.util.*;

public class T17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] sa = new String[]{"", "", "abc", "def","ghi", "jkl", "mno","pqrs","tuv","wxyz"};

        backtrack(res, sa, digits, 0, new StringBuilder());

        return res;
    }


    private void backtrack(List<String> res, String[] sa, String digits, int index, StringBuilder sb){
        if(index > digits.length()){
            return;
        }
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String button = sa[digit];

        for(int i = 0; i < button.length(); i++){
            int length = sb.length();
            sb.append(button.charAt(i));
            backtrack(res, sa, digits, index + 1, sb);
            sb.setLength(length);
        }
    }
}
