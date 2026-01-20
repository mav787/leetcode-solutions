package old.T1_99;

public class TT38sb {
	public String countAndSay(int n) {
        if(n <= 0)
            return "";
        StringBuilder sb = new StringBuilder("1");
        for(int i = 1; i < n; i++){
            sb = countOnce(sb);
        }
        return sb.toString();
    }
    
    private StringBuilder countOnce(StringBuilder s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char digit = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                count++;
            }
            else{
                sb.append(count);
                sb.append(digit);
                count = 1;
                digit = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(digit);
        return sb;
    }
}
