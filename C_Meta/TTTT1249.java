package C_Meta;

public class TTTT1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // 1. left to right, remove invalid ')'s
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                sb.append(c);
                count++;
            }
            else if(c == ')'){
                if(count <= 0) {
                    continue;
                }
                else{
                    sb.append(c);
                    count--;
                }
            }
            else{
                sb.append(c);
            }
        }

        // 2. right to left, remove invalid '('s
        StringBuilder sb2 = new StringBuilder();
        count = 0;

        for(int i = sb.length() - 1; i >= 0; i--){
            char c = sb.charAt(i);
            if(c == ')'){
                sb2.append(c);
                count++;
            }
            else if(c == '('){
                if(count <= 0){
                    continue;
                }
                else{
                    sb2.append(c);
                    count--;
                }
            }
            else{
                sb2.append(c);
            }
        }

        // 3. return result
        return sb2.reverse().toString();
    }
}
