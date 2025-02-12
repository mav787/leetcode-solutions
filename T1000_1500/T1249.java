package T1000_1500;

public class T1249 {
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
                sb.append(c);
            }
            else if(c == ')'){
                if(count <= 0){
                    continue;
                }
                else{
                    count--;
                    sb.append(c);
                }
            }
            else{
                sb.append(c);
            }
        }

        StringBuilder sb2 = new StringBuilder();
        count = 0;

        for(int i = sb.length() - 1; i >=0; i--){
            char c = sb.charAt(i);
            if(c == ')'){
                count++;
                sb2.append(c);
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

        return sb2.reverse().toString();
    }
}
