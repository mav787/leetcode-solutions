package T1_99;

public class TT38 {
	public String countAndSay(int n) {
        if(n <= 0)
            return "";
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countOnce(s);
        }
        return s;
    }
    
    private String countOnce(String s){
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
        return sb.toString();
    }
}
