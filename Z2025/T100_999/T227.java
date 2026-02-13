package Z2025.T100_999;

public class T227 {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int res = 0;
        int curr = 0;
        char prevSign = '+';
        int last = 0;

        s = s.trim();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            }
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }
            if(!Character.isDigit(c) || i == s.length() - 1){
                // this marks the end of the construction of curr. we could proceed with some temp result.
                if(prevSign == '+'){
                    res += last;
                    last = curr;
                }
                else if(prevSign == '-'){
                    res += last;
                    last = -curr;
                }
                else if(prevSign == '*'){
                    last = last * curr;
                }
                else{
                    last = last / curr;
                }

                curr = 0;
                prevSign = c;
            }
        }

        res += last;
        return res;
    }
}
