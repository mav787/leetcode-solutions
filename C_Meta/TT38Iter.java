package C_Meta;

public class TT38Iter {
	public String countAndSay(int n) {
        if(n < 1) return "";
        String res = "1";
        for(int i = 1; i < n; i++){
            res = countOnce(res);
        }
        return res;
    }
    
    private String countOnce(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char curr = s.charAt(0);
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                count++;
            }
            else{
                sb.append(count).append(curr);
                curr = s.charAt(i);
                count = 1;
            }
        }
        
        sb.append(count).append(curr);
        return sb.toString();
    }
}
