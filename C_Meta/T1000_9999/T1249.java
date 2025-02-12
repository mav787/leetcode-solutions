package C_Meta.T1000_9999;

public class T1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder removeClose = remove(sb, '(', ')');
        StringBuilder removeOpen = remove(removeClose.reverse(), ')', '(');
        return removeOpen.reverse().toString();
    }

    private StringBuilder remove(StringBuilder s, char open, char close){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == open){
                count++;
                sb.append(c);
            }
            else if(c == close){
                if(count == 0){
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
        return sb;
    }
}
