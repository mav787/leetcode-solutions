package Z2025.T100_999;

import java.util.*;

public class T301 {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        int leftRemove = 0;
        int rightRemove = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                leftRemove++;
            }
            else if(c == ')'){
                if(leftRemove > 0){
                    leftRemove--;
                }
                else{
                    rightRemove++;
                }
            }
        }

        helper(res, s, 0, 0, leftRemove, rightRemove, new StringBuilder());

        return new ArrayList<>(res);
    }

    private void helper(Set<String> res, String s, int index, int balance,
                        int leftRemove, int rightRemove, StringBuilder sb){
        if(balance < 0 || leftRemove < 0 || rightRemove < 0){
            return;
        }

        if(index == s.length()){
            if(balance == 0 && leftRemove == 0 && rightRemove == 0){
                res.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int length = sb.length();

        if(c == '('){
            helper(res, s, index + 1, balance,
                    leftRemove - 1, rightRemove, sb);

            sb.append(c);
            helper(res, s, index + 1, balance + 1,
                    leftRemove, rightRemove, sb);
        }
        else if(c == ')'){
            helper(res, s, index + 1, balance,
                    leftRemove, rightRemove - 1, sb);

            sb.append(c);
            helper(res, s, index + 1, balance - 1,
                    leftRemove, rightRemove, sb);
        }
        else{
            sb.append(c);
            helper(res, s, index + 1, balance,
                    leftRemove, rightRemove, sb);
        }

        sb.setLength(length);
    }
}
