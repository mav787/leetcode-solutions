package Z2025.T100_999;
import java.util.*;

public class T224 {
    public int calculate(String s) {
        Stack<Integer> result = new Stack<>();
        Stack<Integer> signs = new Stack<>();

        int res = 0, curr = 0, nextSign = 1;
        boolean isNum = false;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                if(!isNum){
                    isNum = true;
                    curr = c - '0';
                }
                else{
                    curr = curr * 10 + (c - '0');
                }
            }
            else if(c == ' '){
                isNum = false;
                // continue;
            }

            else if(c == '+'){
                res = res + nextSign * curr;
                curr = 0;
                nextSign = 1;
                isNum = false;
            }
            else if(c == '-'){
                res = res + nextSign * curr;
                curr = 0;
                nextSign = -1;
                isNum = false;
            }

            else if(c == '('){
                result.push(res);
                signs.push(nextSign);

                res = 0;
                nextSign = 1;

                isNum = false;
            }
            else if(c == ')'){
                res = res + nextSign * curr;
                res = result.pop() + signs.pop() * res;
                curr = 0;
                nextSign = 1;

                isNum = false;
            }
        }

        res = res + nextSign * curr;
        return res;
    }
}
