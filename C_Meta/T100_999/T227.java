package C_Meta.T100_999;

public class T227 {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int last = 0;
        int curr = 0;
        char sign = '+';
        int res = 0;

        s = s.trim();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }
            if(!Character.isDigit(c) || i == s.length() - 1){
                if(sign == '+'){
                    res += last;
                    last = curr;
                }
                else if(sign == '-'){
                    res += last;
                    last = -curr;
                }
                else if(sign == '*'){
                    last = last * curr;
                }
                else{
                    last = last / curr;
                }

                curr = 0;
                sign = c;
            }
        }

        res += last;
        return res;
    }
}
